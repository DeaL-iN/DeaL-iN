//
//  ViewController.swift
//  DeaL-iN
//
//  Created by 송주 on 2022/02/06.
//

import UIKit

class MainViewController: UIViewController {

    @IBOutlet weak var merchandiseListCollectionView: UICollectionView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.merchandiseListCollectionView.delegate = self
        self.merchandiseListCollectionView.dataSource = self
        
        merchandiseListCollectionView.register(<#T##cellClass: AnyClass?##AnyClass?#>, forCellWithReuseIdentifier: <#T##String#>)
    }
}

extension MainViewController: UICollectionViewDelegate {
    
}

extension MainViewController: UICollectionViewDataSource {
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        
    }
}
