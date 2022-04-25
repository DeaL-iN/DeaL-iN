//
//  MerchandiseListCollectionViewCell.swift
//  DeaL-iN
//
//  Created by 송주 on 2022/02/07.
//

import UIKit

class MerchandiseListCollectionViewCell: UICollectionViewCell {
    
    static let identifier: String = "MerchandiseListCollectionViewCell"
    
    @IBOutlet weak var thumbnailImageView: UIImageView!
    @IBOutlet weak var merchandiseNameLabel: UILabel!
    @IBOutlet weak var priceLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
    }
    
    public func configure(image: UIImage, merchandiseName: String, price: String) {
        merchandiseNameLabel?.text = merchandiseName
        priceLabel?.text = price
        thumbnailImageView.backgroundColor = UIColor(red: 100, green: 100, blue: 100, alpha: 1)
        thumbnailImageView.image = image
    }

}
