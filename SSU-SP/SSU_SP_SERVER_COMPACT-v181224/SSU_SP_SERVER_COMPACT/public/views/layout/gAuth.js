<script>
  function init(){" "}
  {gapi.load("auth2", function() {
    // Ready.
    console.log("init");
    var gAuth = gapi.auth2.init({
      client_id:
        "1061772153909-citglfu2e8aspftblbvq1n76ie55g0em.apps.googleusercontent.com"
    });

    gAuth.then(
      function() {
        console.log("googleAuth Success");
        if (gAuth.isSignedIn.get()) {
          console.log("logined");
        } else {
          console.log("logouted");
        }
      },
      function() {
        console.log("googleAuth fail");
      }
    );
  })}
</script>;

//구글 인증 부분인데, 이부분을 이용해서, 로그인 체크를 할 것이다. 리 다이렉트로 제어해보자.
// 헤더 파일로 만들어서 html include 를 해볼려고 했으나, 그냥 페이지에 다 삽입해버리자.
