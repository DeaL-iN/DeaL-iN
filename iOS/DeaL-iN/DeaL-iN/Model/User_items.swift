//
//  User_items.swift
//  DeaL-iN
//
//  Created by 송주 on 2022/03/28.
//

import Foundation

struct Users_items: Hashable {
    var id: Int
    var item_id: Int
    var user_id: Int
    var price: Int
    var deal_date: Date
    var is_purchase: Bool
}
