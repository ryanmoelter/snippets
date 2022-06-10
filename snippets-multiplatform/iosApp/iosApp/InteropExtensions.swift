//
//  InteropExtensions.swift
//  iosApp
//
//  Created by Ryan Moelter on 6/9/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared

extension SharedDimensions: ObservableObject {
}

extension SharedDp {
  func pt() -> CGFloat {
    CGFloat(value)
  }
}
