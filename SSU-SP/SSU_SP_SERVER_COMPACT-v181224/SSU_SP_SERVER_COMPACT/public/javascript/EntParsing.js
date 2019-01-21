//파싱 모듈을 만들자.
module.exports.wordParsing = function(data) {
  for (var i = 0; i < data.length; i++) {
    console.log("wordParsing input text 확인 : " + data[i]);
    data[i] = data[i].trim();
    //console.log("wordParsing input text 트림 : " + data[i]);
  }
  //var sentenceData = data; //문자 넣기
  var tempWord = new Array();
  var resultText = new Array();

  for (var i = 0; i < data.length; i++) {
    tempWord[i] = data[i].split(" ");
  }

  for (var i = 0; i < tempWord.length; i++) {
    console.log("테스트 구조  i " + i + " = " + tempWord[i]);
  }
  return tempWord;
};

//파싱모듈
module.exports.entParsing = function(inputText) {
  console.log("input text 확인 : " + inputText);
  var text = inputText; //문자 넣기

  console.log("text 바인딩 확인 : " + inputText);
  var tempText = new Array();
  var tempText2 = new Array();
  var tempText3 = new Array();
  var resultText = new Array();

  var findStr = new Array(); //배열선언
  findStr[0] = ".";
  findStr[1] = "!";
  findStr[2] = "?";

  console.log("findstr 확인 : " + findStr);

  //순서1
  tempText = text.split(findStr[0]);
  console.log("tempText 확인 : " + tempText);

  //순서2
  for (var i = 0; i < tempText.length; i++) {
    if (tempText[i].indexOf(findStr[1]) == -1) {
      resultText.push(tempText[i] + ".");
      continue;
    }
    tempText2 = tempText[i].split(findStr[1]);
  } //for2 end
  console.log("tempText2 확인 : " + tempText2);

  //공백 배열 검사 후 삭제
  for (var i = 0; i < tempText2.length; i++) {
    if (tempText2[i].length == 0) {
      tempText2.splice(i);
    }
  }

  //! 빠진거 다시 넣어주기
  for (var i = 0; i < tempText2.length; i++) {
    if (tempText2[i].indexOf(findStr[2]) != -1) {
      //?가 있따면
      console.log("tempText2 i 확인 : " + i);

      tempText2[i] = tempText2[i] + "!";
    }
  }

  //순서 3
  for (var i = 0; i < tempText2.length; i++) {
    if (tempText2[i].indexOf(findStr[2]) == -1) {
      //tempText2[i] = tempText2[i] + "!";
      console.log("tempText2 후if : " + tempText2[i]);
      resultText.push(tempText2[i] + "!");
      continue;
    }
    tempText3 = tempText2[i].split(findStr[2]);
  } //for3 end

  console.log("resultText 확인11 = " + resultText);

  // ? 빠진거 체크해서 넣기
  for (var i = 0; i < tempText3.length; i++) {
    if (tempText3[i].indexOf(findStr[1]) == -1) {
      resultText.push(tempText3[i] + "?");
    } else {
      resultText.push(tempText3[i]);
    }
  }

  console.log("tempText3 확인 = " + tempText3);
  console.log("resultText 확인22 = " + resultText);

  return resultText;
};
