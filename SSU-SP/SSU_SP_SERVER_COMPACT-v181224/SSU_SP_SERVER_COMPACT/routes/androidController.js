var express = require("express");
var router = express.Router();
var mysql = require("mysql"); //MYsql 연동모듈
var fs = require("fs"); //파일시스템
var ejs = require("ejs");

var bodyParser = require("body-parser");

router.use(bodyParser.urlencoded({ extended: false }));

//mysql db 연결 함수

var pool = mysql.createPool({
  connectionLimit: 10,
  host: "127.0.0.1",
  user: "root",
  port: "3309",
  database: "entstudy",
  password: "ssu_sp_mainduke"
});

//디비 연결 함수
function getConnection() {
  return pool;
}

router.get("/androidTest", function(req, res) {
  console.log("안드로이드 접속테스트");

  var testStirng = "select * from products";
  getConnection().query(testStirng, function(err, rows) {
    console.log(rows);

    res.json(rows);
  });

  console.log(testStirng);
}); //test end

//안드로이드 메인화면
router.get("/android/entmain", function(req, res) {
  console.log("메인화면");
  //main 으로 들어오면 바로 페이징 처리
  res.redirect("/android/entpasing/" + 1);
});

//안드로이드 메인화면
router.get("/android/entMainList", function(req, res) {
  var queryString = "select * from ent_info order by entId desc limit 0,10";
  getConnection().query(queryString, function(error, result) {
    if (error) {
      console.log("페이징 에러" + error);
      return;
    }
    res.json(result);
    console.log(result);
  });
});

router.get("/android/entpasing/:cur", function(req, res) {
  console.log("안드로이드 접속 = ENTLIST");

  //페이지당 게시물 수 : 한 페이지 당 10개 게시물
  var page_size = 10;
  //페이지의 갯수 : 1 ~ 10개 페이지
  var page_list_size = 10;
  //limit 변수
  var no = "";
  //전체 게시물의 숫자
  var totalPageCount = 0;

  var queryString = "select count(*) as cnt from ent_info";
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

    var queryString = "select * from ent_info order by entId desc limit ?,?";
    getConnection().query(queryString, [no, page_size], function(
      error,
      result
    ) {
      if (error) {
        console.log("페이징 에러" + error);
        return;
      }
      res.json({ data: result, pasing: result2 });
      console.log(result);
    });
  });
}); //test end

module.exports = router;
