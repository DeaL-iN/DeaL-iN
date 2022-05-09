//
//  ViewController.swift
//  DeaL-iN
//
//  Created by 송주 on 2022/02/06.
//

import UIKit

class MainViewController: UIViewController {
    
    let dummy = ["상품1", "상품2", "상품3", "상품4"]
    let dummy2 = ["디지털기기", "생활가전", "여성잡화", "게임/취미"]

    @IBOutlet weak var merchandiseListCollectionView: UICollectionView!
    @IBOutlet weak var navigationBar: UINavigationItem!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.merchandiseListCollectionView.delegate = self
        self.merchandiseListCollectionView.dataSource = self
        merchandiseListCollectionView.register(UINib(nibName: MerchandiseListCollectionViewCell.identifier, bundle: nil), forCellWithReuseIdentifier: MerchandiseListCollectionViewCell.identifier)
        merchandiseListCollectionView.register(UINib(nibName: CategoryCollectionViewCell.identifier, bundle: nil), forCellWithReuseIdentifier: CategoryCollectionViewCell.identifier)
        navigationItem.title = "DeaL-iN"
    }
}

extension MainViewController: UICollectionViewDelegate {
    
}

extension MainViewController: UICollectionViewDataSource {
    func numberOfSections(in collectionView: UICollectionView) -> Int {
        return 2
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        if(section == 0) {
            return dummy2.count
        }
        return dummy.count
    }
    
    func collectionView(_ collectionView: UICollectionView, viewForSupplementaryElementOfKind kind: String, at indexPath: IndexPath) -> UICollectionReusableView {
        let header = collectionView.dequeueReusableSupplementaryView(ofKind: kind, withReuseIdentifier: "header", for: indexPath) as! MainHeaderView
        if (indexPath.section == 0) {
            header.headerLabel?.text = "Category"
        } else {
            header.headerLabel?.text = "Hot List"
        }
        return header
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        if(indexPath.section == 0) {
            guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: CategoryCollectionViewCell.identifier, for: indexPath) as? CategoryCollectionViewCell else {
                return UICollectionViewCell()
            }
            cell.configure(categoryName: dummy2[indexPath.row])
            return cell
        }
        guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: MerchandiseListCollectionViewCell.identifier, for: indexPath) as? MerchandiseListCollectionViewCell else {
            return UICollectionViewCell()
        }
        cell.configure(image: UIImage(named: String(indexPath.row))!, merchandiseName: dummy[indexPath.row], price: String(indexPath.row * 1000000))
        return cell
        
    }
}

extension MainViewController: UICollectionViewDelegateFlowLayout {
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        if(indexPath.section == 0) {
            let wordSize = dummy2[indexPath.row].count
            let itemSpacing: CGFloat = 10
            let width: CGFloat = (collectionView.bounds.width-itemSpacing) / 4.5 + CGFloat(wordSize)
            let height: CGFloat = width / 3 //셀 하나의 높이
            return CGSize(width: width, height: height)
        }
        let itemSpacing: CGFloat = 10
        let width: CGFloat = (collectionView.bounds.width-itemSpacing) / 2
        let height: CGFloat = width //셀 하나의 높이

        return CGSize(width: width, height: height)
    }
}
