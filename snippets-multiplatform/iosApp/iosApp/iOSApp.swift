import SwiftUI
import shared

@main
struct iOSApp: App {
	var body: some Scene {
		WindowGroup {
			ContentView()
        // In a real app, we would provide this through dependency injection
        .environmentObject(SharedDimensions())
		}
	}
}
