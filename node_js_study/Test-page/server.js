var fs = require("fs"),
  express = require("express"),
  bodyParser = require("body-parser"),
  db = require("./db_init.js"),
  app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.use(express.static("static"));
app.get("/", function(req, res) {
  //   res.sendFile("index.html", { root: __dirname + "/static/" });
  res.sendFile("index.html");
});

//클라이언트의 요청에 따라 SQLite DB로부터 문제를 내려받아 클라이언트에게 JSON API 형태로 전달해 줍니다.
app.get("/api/fetchProblem", function(req, res) {
  console.log("패치 요청 들어왔다!");

  db.Problem.findAll()
    .then(function(results) {
      console.log("리턴할꺼야!");
      var tempArray = new Array();

      for (var i = 0; i < results.length; i++) {
        var tempObject = new Object();
        tempObject.id = results[i].id;
        tempObject.problem_text = results[i].problem_text;
        tempObject.type = results[i].type;
        tempObject.choices = results[i].choices;

        tempArray.push(tempObject);
      }

      var totObject = new Object();
      totObject.problems = tempArray;

      res.json(totObject);
    })
    .catch(function(err) {
      console.log("문제 주다가 에러");
      console.log(err);
    });
});

//클라이언트의 채점 요청을 받아 채점을 한 후, JSON API 형태로 채점결과를 전달해 주고, 채점 결과는 DB에 저장합니다.
app.post("/api/submit", function(req, res) {
  console.log("받기 테스트");

  var tempReq = JSON.parse(req.body.input);
  //  console.log(test.length);
  var tempArray = new Array();

  var tempArray2 = db.Problem.findAll()
    .then(function(results) {
      for (var i = 0; i < tempReq.length; i++) {
        var tempObject = new Object();
        //반복
        tempObject.id = tempReq[i].id;
        tempObject.answer = results[i].answer; //답안 참거짓
        if (results[i].answer == tempReq[i].answer) {
          tempObject.result = true;
        } else {
          tempObject.result = false;
        }

        tempArray.push(tempObject);
      }
      var totObject = new Object();
      totObject.results = tempArray;

      res.json(totObject); //데이터 리턴
    })
    .catch(function(err) {
      console.log("받기 - > 답안지");
      console.log(err);
    });
}); //end

var server = app.listen(3000, function() {
  console.log("Server started");
});
