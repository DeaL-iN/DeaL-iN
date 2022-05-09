//
//  CategoryCollectionViewCell.swift
//  DeaL-iN
//
//  Created by 송주 on 2022/05/09.
//

import UIKit

class CategoryCollectionViewCell: UICollectionViewCell {

    static let identifier: String = "CategoryCollectionViewCell"
    
    @IBOutlet weak var categoryLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
    }
    
    public func configure(categoryName: String) {
        categoryLabel.text = categoryName
        categoryLabel.layer.cornerRadius = 12
        categoryLabel.layer.borderWidth = 1
        categoryLabel.layer.borderColor = UIColor.systemPurple.cgColor
    }

}
