package com.example.user.ssu_sp_entstudy.connetor_entStduyList;

import com.example.user.ssu_sp_entstudy.retrofit_test.Contributor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EntStudyList_interface {

    // 원주소 / android / entList /
    // 원 주소 = 서버명
    // "android/entList"

    // (http://localhost:3000) 이부분은 원주소
    // /android/entpasing/1
    // GET/POST/DELETE/PUT 메소드들을 인터페이스에 구현하여 사용할 수 있다.
    @GET("/android/{serverPage}")
    // JSON Array를 리턴하므로 List<>가 되었다

    Call<List<EntStudyList_Property>> serverPageBinder(
            // param 값으로 들어가는 것들이다
            @Path("serverPage") String serverPage);

}
