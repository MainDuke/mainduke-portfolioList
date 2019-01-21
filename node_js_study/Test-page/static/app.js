var App = function($dom) {
  this.$dom = $dom;
  this._initialize();
};

var _ = App.prototype; //app 생성자 실행 후 객체화

//시작
_._initialize = function() {
  this._fetchProblem(); //문제 패치
  this._bindEvents(); //이벤트 바인딩
};

// 이니셜 1 problemStubs 에다가 데이터 받아온다.
_._fetchProblem = function() {
  var that = this;
  console.log("패치 한다~");
  $.get("/api/fetchProblem", function(data) {
    console.log(data);
    that.problemStubs = data.problems.map(function(p) {
      return new ProblemStub(p);
    });
  });
};

//이니셜 2
_._bindEvents = function() {
  var that = this;

  this.$dom.find(".submit").click(function() {
    //html 서브밋 클래스 클릭 이벤트 등록
    $.post(
      "/api/submit",
      {
        //서버에다가 post 방식으로 제이슨 데이터를 전송한다.
        input: JSON.stringify(
          that.problemStubs.map(function(ps) {
            return {
              id: ps.data.id,
              answer: ps.answerObjUser.getAnswer()
            };
          })
        )
      },
      function(data) {
        //콜백
        that._renderResult(data.results); //결과값 화면에 렌더링
        that.$dom.find(".submit").attr("disabled", true); //서브밋 버튼 비활성화
      }
    );
  });
};

//콜백에서 받아온 데이터를 뿌린다.
_._renderResult = function(data) {
  var that = this;

  this.problemStubs.map(function(ps, idx) {
    ps.fillAnswer(data[idx]);
  });

  data.forEach(function(d) {
    var $div = $("<div />");

    $div.html($(".tmpl-result-stub").html());
    $div.find(".id").text(d.id);
    if (d.result) {
      $div.find(".result").text("O");
    } else {
      $div.find(".result").text("X");
    }
    $div.appendTo(".main-result");
  });
};

//ProblemStub
var ProblemStub = function(data) {
  this.data = data;
  this._initialize();
};

_ = ProblemStub.prototype; //프로토타입 객체 바인딩

_._initialize = function() {
  this._setAnswerObj();
  this._setDom();
};

_._setAnswerObj = function() {
  //답안지 세팅 펑션
  switch (this.data.type) {
    case 1:
      this.answerObjUser = new AnswerStubChoice(JSON.parse(this.data.choices));
      this.answerObjRight = new AnswerStubChoice(JSON.parse(this.data.choices));
      break;
    case 2:
      this.answerObjUser = new AnswerStubText();
      this.answerObjRight = new AnswerStubText();
      break;
    case 3:
      this.answerObjUser = new AnswerStubDraw();
      this.answerObjRight = new AnswerStubDraw();
      break;
    default:
      return;
  }
};

_._setDom = function() {
  //문서 바인딩
  this.$dom = $('<div class="problem-stub" />');
  this.$dom.html($(".tmpl-problem-stub").html());
  this.$dom.find(".id").text(this.data.id);
  this.$dom.find(".problem-text").text(this.data.problem_text);
  this.$dom.find(".answer-user").append(this.answerObjUser.$dom);

  this.$dom.appendTo(".problem");
};

_.fillAnswer = function(result) {
  //답안지 비교
  this.answerObjUser.setLabel("나의 답: ");
  this.answerObjRight.setLabel("정답: ");

  this.answerObjRight.fillAnswer(result.answer);
  this.$dom.find(".answer-right").append(this.answerObjRight.$dom);
};

var AnswerStubChoice = function(choices) {
  this.choices = choices;
  this._initialize();
};

//
//여기는 라디오 버튼 !!
_ = AnswerStubChoice.prototype;

_._initialize = function() {
  this._setDom();
};

_._setDom = function() {
  //이름에 랜덤한 숫자를 붙인다.

  var that = this,
    rand = Math.floor(Math.random() * 1000000);

  this.$dom = $('<div class="answer-stub-choice" />');
  this.$dom.html($(".tmpl-answer-stub-choice").html());

  this.choices.forEach(function(c, idx) {
    that.$dom.find('input[type="radio"]').attr("name", "choice_" + rand);
    that.$dom
      .find(".choice")
      .eq(idx) //해당idx 를 C로 입력?
      .text(c);
  });
};

_.getAnswer = function() {
  return this.$dom.find('input[type="radio"]:checked').val();
};

_.fillAnswer = function(value) {
  this.$dom
    .find('input[type="radio"][value="' + value + '"]')
    .attr("checked", true);
};

_.setLabel = function(str) {
  this.$dom.find(".label").text(str);
};

var AnswerStubText = function() {
  this._initialize();
};

//
//여기는 텍스트 값
_ = AnswerStubText.prototype;

_._initialize = function() {
  this._setDom();
};

_._setDom = function() {
  var that = this;

  this.$dom = $('<div class="answer-stub-text" />');
  this.$dom.html($(".tmpl-answer-stub-text").html());
};

_.getAnswer = function() {
  return this.$dom.find(".value").val();
};

_.fillAnswer = function(value) {
  this.$dom.find(".value").val(value);
};

_.setLabel = function(str) {
  this.$dom.find(".label").text(str);
};

var AnswerStubDraw = function() {
  this._initialize();
};

//여기는 캔바스
_ = AnswerStubDraw.prototype;

_._initialize = function() {
  this._setDom();
  this._bindEvents();
};

_._setDom = function() {
  var that = this;

  this.$dom = $('<div class="answer-stub-draw" />');
  this.$dom.html($(".tmpl-answer-stub-draw").html());
  this.$dom.find(".canvas").attr({
    width: 125,
    height: 125
  });
};

_._bindEvents = function() {
  var that = this;

  this.ctx = this.$dom.find(".canvas")[0].getContext("2d");
  this.mousedown = false;

  this.$dom.find(".canvas").mousedown(function() {
    that.mousedown = true;
  });

  this.$dom.find(".canvas").mouseup(function() {
    that.mousedown = false;
  });

  this.$dom.find(".canvas").mouseleave(function() {
    that.mousedown = false;
  });

  this.$dom.find(".canvas").mousemove(function(e) {
    if (that.mousedown) {
      that.ctx.fillRect(e.offsetX, e.offsetY, 1, 1);
    }
  });
};

_.getAnswer = function() {
  return this.$dom.find(".canvas")[0].toDataURL();
};

_.fillAnswer = function(value) {
  var img = new Image();
  img.src = value;
  this.ctx.drawImage(img, 0, 0);
};

_.setLabel = function(str) {
  this.$dom.find(".label").text(str);
};
