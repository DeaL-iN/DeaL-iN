//
//  Users.swift
//  DeaL-iN
//
//  Created by 송주 on 2022/03/28.
//

import Foundation

struct Categories: Hashable {
    var id: Int
    var name: String
}

struct Users: Hashable {
    var id: Int
    var email: String
    var password: String
    var name: String
    var nickname: String
    var tel: String
    var address: String
    var address_detail: String
    var point: Int
    var grade: String
    var is_deleted: Bool
    var profile_image_url: String
    var blacklist: Bool
    var created_at: Date
    var updated_at: Date
}
