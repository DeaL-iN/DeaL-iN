////
////  NetworkManager.swift
////  DeaL-iN
////
////  Created by 송주 on 2022/03/07.
////
//
//import Foundation
//import Alamofire
//
//class NetworkManager {
//    let url: String = "http://dealin.cewz49vcfgmy.us-east-1.rds.amazonaws.com:3306"
//
//    /* GET */
//
//    // 상품 목록 조회
//    func getItemList(id: String) -> DataRequest? {
//        var urlString = url + "/api/items/" + id
//        AF.request(url, method: .get, parameters: nil, encoding: URLEncoding.default, headers: ["Content-Type":"application/json", "Accept":"application/json"])
//                .validate(statusCode: 200..<300)
//                .responseJSON { (json) in
//                    return json
//                }
//    }
//
//    // 상품 조회
//    func getItem(itemId: String) -> DataRequest? {
//        var urlString = url + "/api/items/" + itemId
//        AF.request(url, method: .get, parameters: nil, encoding: URLEncoding.default, headers: ["Content-Type":"application/json", "Accept":"application/json"])
//                .validate(statusCode: 200..<300)
//                .responseJSON { (json) in
//                    return json
//                }
//    }
//
//    // 상품 입찰 여부
//    func getItemBid(itemId: String) -> DataRequest? {
//        var urlString = url + "/api/items/" + itemId + "/bid/"
//        AF.request(url, method: .get, parameters: nil, encoding: URLEncoding.default, headers: ["Content-Type":"application/json", "Accept":"application/json"])
//                .validate(statusCode: 200..<300)
//                .responseJSON { (json) in
//                    return json
//                }
//    }
//
//    // 상품 입찰자 확인
//    func getItemPurchaser(itemId: String) -> DataRequest? {
//        var urlString = url + "/api/items/" + itemId + "/bids/"
//        AF.request(url, method: .get, parameters: nil, encoding: URLEncoding.default, headers: ["Content-Type":"application/json", "Accept":"application/json"])
//                .validate(statusCode: 200..<300)
//                .responseJSON { (json) in
//                    return json
//                }
//    }
//
//    // 상품 검색
//    func getItemPurchaser(id: String, keyword: String, categoryId: String) -> DataRequest? {
//        var urlString = url + "/api/items/" + id + "?keyword=" + keyword + "&categoryId=" + categoryId
//        AF.request(url, method: .get, parameters: nil, encoding: URLEncoding.default, headers: ["Content-Type":"application/json", "Accept":"application/json"])
//                .validate(statusCode: 200..<300)
//                .responseJSON { (json) in
//                    return json
//                }
//    }
//
//    // 채팅방 리스트 조회
//    func getChatRoomsList() -> DataRequest? {
//        var urlString = url + "/api/chat-rooms/users/"
//        AF.request(url, method: .get, parameters: nil, encoding: URLEncoding.default, headers: ["Content-Type":"application/json", "Accept":"application/json"])
//                .validate(statusCode: 200..<300)
//                .responseJSON { (json) in
//                    return json
//                }
//    }
//
//    // 채팅방 입장
//    func getRoomIn(roomId: String) -> DataRequest? {
//        var urlString = url + "/api/chat-rooms/" + roomId + "/chats"
//        AF.request(url, method: .get, parameters: nil, encoding: URLEncoding.default, headers: ["Content-Type":"application/json", "Accept":"application/json"])
//                .validate(statusCode: 200..<300)
//                .responseJSON { (json) in
//                    return json
//                }
//    }
//}
