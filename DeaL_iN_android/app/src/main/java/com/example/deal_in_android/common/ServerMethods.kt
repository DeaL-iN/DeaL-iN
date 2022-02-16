package com.example.deal_in_android.common


import com.example.deal_in_android.common.entity.Items
import com.example.deal_in_android.common.entity.Users
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import java.sql.Time
import java.util.*

interface ServerMethods{

    // 회원 관련
    /**
     * 회원가입
     *
     * @param body 회원 정보 객체
     * @return ResponseBody
     */
    @Headers("Content-Type: application/json")
    @POST("/api/user")
    fun userRegister(@Body body: Users) : Call<ResponseBody>

    /**
     * 로그인
     *
     * @param email 이메일 주소
     * @param password 비밀번호 문자열
     * @return
     */
    @Headers("Content-Type: application/json")
    @POST("/api/user/login")
    fun userLogin(
        @Query("email") email: String,
        @Query("password") password: String
    ) : Call<ResponseBody>

    /**
     * 이메일 중복조회
     *
     * @param email 이메일 주소
     * @return
     */
    @Headers("Content-Type: application/json")
    @GET("/api/user/email/{email}")
    fun emailCheck(@Path("email") email:String) : Call<ResponseBody>

    /**
     * 닉네임 중복조회
     *
     * @param nickname 닉네임
     * @return
     */
    @Headers("Content-Type: application/json")
    @GET("/api/user/nickname/{nickname}")
    fun nicknameCheck(@Path("nickname") nickname:String) : Call<ResponseBody>

    // 아래 회원 관련 API는 JWT Token 필요
    /**
     * 회원정보 조회
     *
     * @return
     */
    @Headers("Content-Type: application/json")
    @GET("/api/user")
    fun getUserInfo() : Call<ResponseBody>

    /**
     * 회원정보 수정
     *
     * @param body 수정하는 회원 객체
     * @return
     */
    @Headers("Content-Type: application/json")
    @PUT("/api/user")
    fun editUserInfo(@Body body:Users) : Call<ResponseBody>

    /**
     * 회원 탈퇴
     *
     * @return
     */
    @Headers("Content-Type: application/json")
    @DELETE("/api/user")
    fun deleteUserInfo() : Call<ResponseBody>

    /**
     * 포인트 충전
     *
     * @param point 충전되는 포인트의 양
     * @return
     */
    @Headers("Content-Type: application/json")
    @PUT("/api/user/point")
    fun addPoint(@Query("point") point: Int) : Call<ResponseBody>

    /**
     * 현재 회원이 가지고 있는 포인트
     *
     * @return
     */
    @Headers("Content-Type: application/json")
    @GET("/api/user/point")
    fun getPoint() : Call<ResponseBody>

    /**
     * 입찰 현황 조회
     *
     * @param id 기본값 1, 스크롤 로딩을 위한 값
     * @return
     */
    @Headers("Content-Type: application/json")
    @GET("/api/user/bids/{id}")
    fun getBidList(@Path("id") id:Int) : Call<ResponseBody>

    /**
     * 구매 목록 조회
     *
     * @param id 기본값 1, 스크롤 로딩을 위한 값
     * @return
     */
    @Headers("Content-Type: application/json")
    @GET("/api/user/buys/{id}")
    fun getBuyList(@Path("id") id:Int) : Call<ResponseBody>

    /**
     * 판매 목록 조회
     *
     * @param id 기본값 1, 스크롤 로딩을 위한 값
     * @return
     */
    @Headers("Content-Type: application/json")
    @GET("/api/user/sells/{id}")
    fun getSellList(@Path("id") id:Int) : Call<ResponseBody>

    /**
     * 입찰자 정보 조회
     *
     * @return
     */
    @Headers("Content-Type: application/json")
    @GET("/api/user/bid")
    fun getBidder() : Call<ResponseBody>


    //상품 관련
    /**
     * 상품 등록
     *
     * @param body 상품 정보 객체
     * @return
     */
    @Headers("Content-Type: application/json")
    @POST("/api/items")
    fun addItem(@Body body: Items) : Call<ResponseBody>

    /**
     * 상품 목록 조회
     *
     * @param id
     * @return
     */
    @Headers("Content-Type: application/json")
    @GET("/api/items/{id}")
    fun getItemList(@Path("id") id: Int) : Call<ResponseBody>

    /**
     * 상품 1개 조회
     *
     * @param itemId 상품 ID
     * @return
     */
    @Headers("Content-Type: application/json")
    @GET("/api/items/{itemId}")
    fun getItemInfo(@Path("itemId") itemId: Int) : Call<ResponseBody>

    /**
     * 위시리스트 추가
     *
     * @param wish false: 등록, true: 해제
     * @param itemId
     * @return
     */
    @Headers("Content-Type: application/json")
    @POST("/api/items/wish")
    fun addWishList(
        @Query("wish") wish: Boolean,
        @Query("itemId") itemId: Int
    ) : Call<ResponseBody>

    /**
     * 상품 입찰 여부 확인
     *
     * @param itemId
     * @return
     */
    @Headers("Content-Type: application/json")
    @GET("/api/items/{itemId}/bid")
    fun checkBidding(@Path("itemId") itemId: Int) : Call<ResponseBody>

    /**
     * 상품 입찰
     *
     * @param itemId
     * @param price
     * @param dealDate
     * @return
     */
    @Headers("Content-Type: application/json")
    @POST("/api/items/bid")
    fun startBidding(
        @Query("itemId") itemId: Int,
        @Query("price") price: Int,
        @Query("deal_date") dealDate: Time
    ) : Call<ResponseBody>

    /**
     * 상품 재입찰
     *
     * @param itemId
     * @param price
     * @param dealDate
     * @return
     */
    @Headers("Content-Type: application/json")
    @PUT("/api/items/bid")
    fun restartBidding(
        @Query("itemId") itemId: Int,
        @Query("price") price: Int,
        @Query("deal_date") dealDate: Time
    ) : Call<ResponseBody>

    /**
     * 상품 구매 확정
     *
     * @param itemId
     * @param point
     * @return
     */
    @Headers("Content-Type: application/json")
    @PUT("/api/items/buy")
    fun buyItem(
        @Query("itemId") itemId: Int,
        @Query("point") point: Int
    ) : Call<ResponseBody>

    /**
     * 상품 입찰자 확인
     *
     * @param itemId
     * @return
     */
    @Headers("Content-Type: application/json")
    @GET("/api/items/{itemId}/bid")
    fun checkBidder(@Path("itemId") itemId: Int) : Call<ResponseBody>

    /**
     * 상품 구매 포기
     *
     * @param itemId
     * @param price
     * @return
     */
    @Headers("Content-Type: application/json")
    @DELETE("/api/items/end")
    fun cancelBidding(
        @Query("itemId") itemId: Int,
        @Query("price") price: Int
    ) : Call<ResponseBody>

    /**
     * 상품 검색
     *
     * @param id
     * @param keyword
     * @param categoryId
     * @return
     */
    @Headers("Content-Type: application/json")
    @GET("/api/items/{id}?keyword={keyword}&categoryId={categoryId}")
    fun searchByCategory(
        @Path("id") id: Int,
        @Path("keyword") keyword: Int,
        @Path("categoryId") categoryId: Int
    ) : Call<ResponseBody>

}