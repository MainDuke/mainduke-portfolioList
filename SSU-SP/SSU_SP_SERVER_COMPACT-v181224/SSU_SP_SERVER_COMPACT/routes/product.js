//가장 중요한 부분. 웹브라우저에서 넘어오는 url을 전부 이곳에서 받는다.
//유심히 보아야 할 부분이 /main 부분과 /pasing/"cur 부분이다.

var express = require("express");
var router = express.Router();
var mysql = require("mysql"); //MYsql 연동모듈
var fs = require("fs"); //파일시스템
var ejs = require("ejs");

//ejs 템플잇 엔진
//엔진의 문법과 설정에 따라서 파일을 HTML 형식으로 변환시키는 모듈입니다.
//JADE 템플릿 모듈은 문법이 다르나 EJS는 <%%> 을 사용해서 문법 가능.
// <%자바스크립트 코드%>
// <%출력할 자바스크립트 객체%> , 여기서 자바스크립트 객체를 ROUTER 에서 받아올수도 있다.
var bodyParser = require("body-parser");

router.use(bodyParser.urlencoded({ extended: false }));
//extended 는 req 객체의 body에 대한 url Encoding의 확장을 할 수 있도록 exteneded:true 라는 옵션을
//설정합니다.

//게시판 페이징
router.get("/pasing/:cur", function(req, res) {
  //페이지당 게시물 수 : 한 페이지 당 10개 게시물
  var page_size = 10;
  //페이지의 갯수 : 1 ~ 10개 페이지
  var page_list_size = 10;
  //limit 변수
  var no = "";
  //전체 게시물의 숫자
  var totalPageCount = 0;

  var queryString = "select count(*) as cnt from products";
  getConnection().query(queryString, function(error2, data) {
    if (error2) {
      console.log(error2 + "메인 화면 mysql 조회 실패");
      return;
    }
    //전체 게시물의 숫자
    //data에는 products 테이블의 갯수가 들어있다.
    totalPageCount = data[0].cnt;

    //현제 페이지
    //cur 가 리턴된 req 객체에서 뽑는다.
    var curPage = req.params.cur;

    console.log("현재 페이지 : " + curPage, "전체 페이지 : " + totalPageCount);

    //전체 페이지 갯수
    if (totalPageCount < 0) {
      totalPageCount = 0;
    }

    var totalPage = Math.ceil(totalPageCount / page_size); // 전체 페이지수
    var totalSet = Math.ceil(totalPage / page_list_size); //전체 세트수
    var curSet = Math.ceil(curPage / page_list_size); // 현재 셋트 번호
    var startPage = (curSet - 1) * 10 + 1; //현재 세트내 출력될 시작 페이지
    var endPage = startPage + page_list_size - 1; //현재 세트내 출력될 마지막 페이지

    //현재페이지가 0 보다 작으면
    if (curPage < 0) {
      no = 0;
    } else {
      //0보다 크면 limit 함수에 들어갈 첫번째 인자 값 구하기
      no = (curPage - 1) * 10;
    }

    console.log(
      "[0] curPage : " +
        curPage +
        " | [1] page_list_size : " +
        page_list_size +
        " | [2] page_size : " +
        page_size +
        " | [3] totalPage : " +
        totalPage +
        " | [4] totalSet : " +
        totalSet +
        " | [5] curSet : " +
        curSet +
        " | [6] startPage : " +
        startPage +
        " | [7] endPage : " +
        endPage
    );

    var result2 = {
      curPage: curPage,
      page_list_size: page_list_size,
      page_size: page_size,
      totalPage: totalPage,
      totalSet: totalSet,
      curSet: curSet,
      startPage: startPage,
      endPage: endPage
    };

    //list.html 로 연결하기 위한 ~~! 렌더링 하는 !
    fs.readFile("./public/views/list.html", "utf-8", function(error, data) {
      if (error) {
        console.log("ejs오류" + error);
        return;
      }
      console.log("몇번부터 몇번까지냐~~~~~~~" + no);

      var queryString = "select * from products order by id desc limit ?,?";
      getConnection().query(queryString, [no, page_size], function(
        error,
        result
      ) {
        if (error) {
          console.log("페이징 에러" + error);
          return;
        }

        //express deprecated res.send(status, body): Use res.status(status).send(body) instead routes\product.js:114:13

        res.send(
          //mysql에서 가져온 데이터(result)와 페이징 관련 데이터 results2를 각각 data, pasing 키에 담았다!
          //이 키 값이 그대로 list.html로 넘어간다.

          ejs.render(data, {
            data: result,
            pasing: result2
          })
        );
      });
    });
  });
}); //pasing end

//메인화면
router.get("/main", function(req, res) {
  console.log("메인화면");
  //main 으로 들어오면 바로 페이징 처리
  res.redirect("/pasing/" + 1);
});

//삭제
router.get("/delete/:id", function(req, res) {
  console.log("삭제 진행");

  getConnection().query(
    "delete from products where id = ?",
    [req.params.id],
    function() {
      res.redirect("/main");
    }
  );
});

//로그인 리다이렉트
router.get("/", function(req, res) {
  console.log("/ 화면, 로그인으로 리다이렉트");

  // fs.readFile("./public/views/index.html", "utf-8", function(error, data) {
  //   res.send(data);
  // });

  res.redirect("/login");
});

//삽입 페이지
router.get("/login", function(req, res) {
  console.log("로그인페이지");

  fs.readFile("./public/views/login.html", "utf-8", function(error, data) {
    res.send(data);
  });
});

//삽입 페이지
router.get("/insert", function(req, res) {
  console.log("삽입 페이지 나와라");

  fs.readFile("viewsinsert.html", "utf-8", function(error, data) {
    res.send(data);
  });
});
//삽입 포스터 데이터
router.post("/insert", function(req, res) {
  console.log("삽입 포스트 데이터 진행");
  var body = req.body;
  getConnection().query(
    "insert into products(name,modelnumber,series) values (?,?,?)",
    [body.name, body.num, body.section],
    function() {
      //응답
      res.redirect("/main");
    }
  );
});
//수정 페이지
router.get("/edit/:id", function(req, res) {
  console.log("수정 진행");

  fs.readFile("./public/views/edit.html", "utf-8", function(error, data) {
    getConnection().query(
      "select * from products where id = ?",
      [req.params.id],
      function(error, result) {
        res.send(
          ejs.render(data, {
            data: result[0]
          })
        );
      }
    );
  });
});
//수정 포스터 데이터
router.post("/edit/:id", function(req, res) {
  console.log("수정 포스트 진행");
  var body = req.body;
  getConnection().query(
    "update products set name = ?, modelnumber = ?, series = ? where id = ?",
    [body.name, body.num, body.section, req.params.id],
    function() {
      res.redirect("/main");
    }
  );
});

//글상세보기
router.get("/detail/:id", function(req, res) {
  console.log("수정 진행");

  fs.readFile("./public/views/detail.html", "utf-8", function(error, data) {
    getConnection().query(
      "select * from products where id = ?",
      [req.params.id],
      function(error, result) {
        res.send(
          ejs.render(data, {
            data: result[0]
          })
        );
      }
    );
  });
});
//mysql db 연결 함수

var pool = mysql.createPool({
  connectionLimit: 10,
  host: "127.0.0.1",
  user: "root",
  port: "3309",
  database: "books",
  password: "ssu_sp_mainduke"
});

//디비 연결 함수
function getConnection() {
  return pool;
}

module.exports = router;
