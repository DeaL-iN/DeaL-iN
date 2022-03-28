//
//  Chat_chats.swift
//  DeaL-iN
//
//  Created by 송주 on 2022/03/28.
//

import Foundation

struct Chat_chats: Hashable {
    var id: Int
    var room_id: Int
    var sender_id: Int
    var contents: String
    var image_url: String
    var created_at: Date
}
