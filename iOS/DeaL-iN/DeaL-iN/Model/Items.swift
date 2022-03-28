//
//  Items.swift
//  DeaL-iN
//
//  Created by 송주 on 2022/03/28.
//

import Foundation

struct Items: Hashable {
    var id: Int
    var name: String
    var category_id: Int
    var seller_id: Int
    var start_price: Int
    var sell_price: Delivery_status
    var deadline_date: Date
    var contents: String
    var is_closed: Bool
    var created_at: Date
}
