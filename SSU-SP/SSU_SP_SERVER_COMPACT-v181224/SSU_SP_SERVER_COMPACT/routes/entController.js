var express = require("express");
var router = express.Router();
var mysql = require("mysql"); //MYsql 연동모듈
var fs = require("fs"); //파일시스템
var ejs = require("ejs");

var bodyParser = require("body-parser");

var EntParsing = require("../public/javascript/EntParsing.js");

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

//게시판 페이징
router.get("/entpasing/:cur", function(req, res) {
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

    // console.log(
    //   "[0] curPage : " +
    //     curPage +
    //     " | [1] page_list_size : " +
    //     page_list_size +
    //     " | [2] page_size : " +
    //     page_size +
    //     " | [3] totalPage : " +
    //     totalPage +
    //     " | [4] totalSet : " +
    //     totalSet +
    //     " | [5] curSet : " +
    //     curSet +
    //     " | [6] startPage : " +
    //     startPage +
    //     " | [7] endPage : " +
    //     endPage
    // );

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
    fs.readFile("./public/views/entlist.html", "utf-8", function(error, data) {
      if (error) {
        console.log("ejs오류" + error);
        return;
      }
      console.log("몇번부터 몇번까지냐~~~~~~~" + no);

      var queryString = "select * from ent_info order by entId desc limit ?,?";
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

//글상세보기
router.get("/entdetail/:entId", function(req, res) {
  console.log("상세보기 진행");

  fs.readFile("./public/views/entdetail.html", "utf-8", function(error, data) {
    getConnection().query(
      "select * from ent_info where entId = ?",
      [req.params.entId],
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

//수정 페이지
router.get("/entedit/:entId", function(req, res) {
  console.log("ent 수정 진행");

  fs.readFile("./public/views/entedit.html", "utf-8", function(error, data) {
    getConnection().query(
      "select * from ent_info where entId = ?",
      [req.params.entId],
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
router.post("/entedit/:entId", function(req, res) {
  console.log("ent 수정 포스트 진행");
  var body = req.body;
  getConnection().query(
    "update ent_info set entTitle = ?,entWriter = ?, entLabel = ?,entEditDate = NOW() ,entLevel =?, entTemptext = ? where entId = ?",
    [
      body.entTitle,
      body.entWriter,
      body.entLabel,
      body.entLevel,
      body.entContents,
      req.params.entId
    ],
    function() {
      res.redirect("/entmain");
    }
  );
});

//삭제
router.get("/entdelete/:entId", function(req, res) {
  console.log("ent 삭제 진행");

  getConnection().query(
    "delete from ent_info where entId = ?",
    [req.params.entId],
    function() {
      res.redirect("/entmain");
    }
  );
});

//메인화면
router.get("/entmain", function(req, res) {
  console.log("메인화면");
  //main 으로 들어오면 바로 페이징 처리
  res.redirect("/entpasing/" + 1);
});

//삽입 페이지
router.get("/entinsert", function(req, res) {
  console.log("ent 삽입 페이지 나와라");

  fs.readFile("./public/views/entInsert.html", "utf-8", function(error, data) {
    res.send(data);
  });
});

//삽입 포스터 데이터
router.post("/entinsert", function(req, res) {
  console.log("ent 삽입 포스트 데이터 진행");
  var body = req.body;

  //원문 내용 파싱 모듈에 연결
  var entText = body.entContents;
  var EntParsingArray = new Array();
  //파싱된 배열 객체
  EntParsingArray = EntParsing.wordParsing(EntParsing.entParsing(entText));

  var entIdGet;

  //실행부분
  inputEntInfo(body); //1. 원문 정보를 입력한다.
  //entId 리턴 받아서 문장 데이터 입력
  inputEntSentence(EntParsingArray); //2. 입력된 원문 ID를 받아서 문장을 저장한다.

  //함수 목록 시작

  function inputEntInfo(body) {
    //원문 저장
    getConnection().query(
      "insert into ent_info(entTitle,entWriter,entLabel,entCreateDate,entEditDate,entLevel,entTemptext) values (?,?,?,NOW(),NOW(),?,?)",
      [
        body.entTitle,
        body.entWriter,
        body.entLabel,
        body.entLevel,
        body.entContents
      ]
    );
  }

  function inputEntSentence(entData) {
    //문장 저장 프로세스 시작
    getConnection().query("SELECT MAX(entId) as entId FROM ent_info", function(
      //마지막에 입력한 글의 ID를 받아온다.
      error,
      data,
      fields
    ) {
      //Object.values(JSON.parse(JSON.stringify(data)));
      //비동기적인 특성으로 인해서, 콜백 함수에서 연속되는 작업을 해야한다.

      //console.log(" data[0].entId 찍는다 = " + data[0].entId);
      //console.log(" EntParsingArray.length = " + EntParsingArray.length);

      //받아온 원문ID 값을 가지는 문장의 코드를 생성한다.
      for (var i = 0; i < entData.length; i++) {
        getConnection().query("insert into ent_sentence(entNum) values (?)", [
          data[0].entId
        ]);
        console.log(" for문 확인 = " + i);
      }

      getConnection().query(
        //4. 입력된 문장 ID 목록을 받는다.
        "select sentenceId from ent_sentence where entNum=?",
        [data[0].entId],
        function(error, result) {
          //var sentenceInfo = result[0];

          // for (var i = 0; i < result.length; i++) {
          //   console.log(
          //     "문장ID 겟 테스트 : i=" + i + " , " + result[i].sentenceId
          //   );
          // }

          // console.log("result.length = " + result.length);
          // console.log("EntParsingArray = " + entData.length);
          for (var i = 0; i < result.length; i++) {
            //문장 갯수 만큼 반복
            for (var j = 0; j < entData[i].length; j++) {
              getConnection().query(
                "insert into ent_word(sentenceNum, wordContents) values (?,?)",
                [result[i].sentenceId, entData[i][j]]
              );
              console.log(
                "result= " +
                  result[i].sentenceId +
                  " , EntParsingArray= " +
                  entData[i][j]
              );
            } //for in
          } //for out
        }
      );
    });
  } //inputEntSentence end

  // //4. 같은 문장 ID 값을 가진 word를 반복해서 넣어준다.

  console.log("삽입 종료");

  res.redirect("/entmain");
});

//삽입 페이지
router.get("/test2", function(req, res) {
  console.log("인풋 테스트");
  inputEntSentence();

  function inputEntSentence() {
    //문장 저장
    getConnection().query("SELECT MAX(entId) as entId FROM ent_info", function(
      error,
      data
    ) {
      //Object.values(JSON.parse(JSON.stringify(data)));

      console.log(" data[0].entId 찍는다 = " + data[0].entId);

      var EntParsingArray = 2;
      for (var i = 0; i < EntParsingArray; i++) {
        getConnection().query("insert into ent_sentence(entNum) values (?)", [
          data[0].entId
        ]);
      }
    });
  }
});

module.exports = router;
