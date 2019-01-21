require("dotenv").config();

var express = require("express");
var app = express();

var morgan = require("morgan"); //로그 모듈 임포트
//명령프롬포트에 로그를 자동으로 찍어주는 모듈이다.
var ejs = require("ejs");
const bodyParser = require("body-parser"); //익스프레스를 쓸땐, 딱히 안 써도 된다.
//이부분 덕분에 POST.REQ 에서 파라미터를 편리하게 추출한다.
//app.use(express.json())
//const connection = require("./database");

//미들웨어 설정
//미들웨어란 하나의 함수를 통해서만 요청이 흘러가는 node.js와 대조적으로 함수를 효과적으로 배열하는 미들웨어스택

app.use(morgan("short")); //로그 미들웨어를 사용한다.
app.use(express.static("./public")); //기본 파일 폴더 위치 설정
app.use(bodyParser.urlencoded({ extended: false }));

app.set("view engine", "ejs");
app.engine("html", require("ejs").renderFile);

//라우트로 분리시켜주기
//라우팅 = HTTP 메서드로 특정 URL 을 방문할때만 함수가 호출됨.
// var productRouter = require("./routes/product.js");
// app.use(productRouter);

//
var entStudyRouter = require("./routes/entController.js");
app.use(entStudyRouter);

//androidController test
var androidController = require("./routes/androidController.js");
app.use(androidController);

// var EntParsing = require("./public/javascript/EntParsing.js");
// var strTest = "test success. cheer up!";
// console.log(EntParsing.wordParsing(EntParsing.entParsing(strTest)));

app.get("/status", (req, res) => res.send("Working!"));

// Port 8080 for Google App Engine
app.set("port", process.env.PORT || 3030);
app.listen(3000, function() {
  console.log("Example app listening on port 3000!");
});
