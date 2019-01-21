//파싱 모듈을 만들자.
module.exports.sum = function(a, b) {
  return a + b;
};

//1. 텍스트를 넣으면, 문장 단위로 끊어야한다. ?/./! 같이 문장이 끝나는 부분을 찾는다.

//2. 한 문장이 준비가 되면, 그 문장을 쉼표나 띄어쓰기 단위로 잘라야한다. 각 토큰은 TRIM 을 이용해서 빈공간을 없앤다.

//3. 각각의 토큰을 배열에 순서대로 저장한 다음에, 순서대로 꺼내서 디비에다가 넣어야한다.
//배열을 라우터쪽으로 넘긴다음에, 순서대로 넣는 것은 라우터쪽에서 해결해도 되겠다. 이부분에서는 파싱 후, 배열 객체를 생성하는 수준이면 될것 같다.

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

//단어 파싱기
function wordParsing(data) {
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
}

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

//문장 단위로 나누는 알고리즘
function entParsing(inputText) {
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
} //function end

//단어 파싱기
function wordParsing(data) {
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
}
