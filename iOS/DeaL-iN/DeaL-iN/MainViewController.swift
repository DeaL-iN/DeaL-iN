//
//  ViewController.swift
//  DeaL-iN
//
//  Created by 송주 on 2022/02/06.
//

import UIKit

class MainViewController: UIViewController {
    
    let dummy = ["상품1", "상품2", "상품3"]

    @IBOutlet weak var merchandiseListCollectionView: UICollectionView!
    @IBOutlet weak var navigationBar: UINavigationItem!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.merchandiseListCollectionView.delegate = self
        self.merchandiseListCollectionView.dataSource = self
        merchandiseListCollectionView.register(UINib(nibName: MerchandiseListCollectionViewCell.identifier, bundle: nil), forCellWithReuseIdentifier: MerchandiseListCollectionViewCell.identifier)
        navigationItem.title = "DeaL-iN"
    }
}

extension MainViewController: UICollectionViewDelegate {
    
}

extension MainViewController: UICollectionViewDataSource {
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return dummy.count
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: MerchandiseListCollectionViewCell.identifier, for: indexPath) as? MerchandiseListCollectionViewCell else {
            return UICollectionViewCell()
        }
        cell.configure(image: UIImage(), merchandiseName: dummy[indexPath.row], price: "1,000,000")
        return cell
        
    }
}

extension MainViewController: UICollectionViewDelegateFlowLayout {
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        let itemSpacing: CGFloat = 10
        let width: CGFloat = (collectionView.bounds.width-itemSpacing) / 2
        let height: CGFloat = width //셀 하나의 높이

        return CGSize(width: width, height: height)
    }
}
