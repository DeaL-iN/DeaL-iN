//
//  Chat_member.swift
//  DeaL-iN
//
//  Created by 송주 on 2022/03/28.
//

import Foundation

struct Chat_member: Hashable {
    var id: Int
    var room_id: Int
    var user_id: Int
    var created_at: Date
}
