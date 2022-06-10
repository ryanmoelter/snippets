import SwiftUI
import shared

struct ContentView: View {
  @EnvironmentObject
  var dimensions: SharedDimensions

  var body: some View {
    ScrollView {
      LazyVStack(alignment: .leading, spacing: 0) {
        Spacer(minLength: dimensions.verticalEdgeSpace.pt())
        Text("Ryan's snippets")
          .font(.title)
          .padding(.horizontal, dimensions.horizontalEdgeSpace.pt())
        Spacer(minLength: dimensions.interItemSpace.pt())
        ForEach(SampleDataKt.sampleItems, id: \.primaryText) { item in
          HStack(alignment: .center, spacing: dimensions.intraItemSpace.pt()) {
            Image(systemName: "star.fill")
              .frame(
                width: dimensions.homeScreen.iconSize.pt(),
                height: dimensions.homeScreen.iconSize.pt()
              )
              .padding(.trailing, dimensions.intraItemSpace.pt())
            VStack(alignment: .leading, spacing: dimensions.intraItemSpace.pt()) {
              Text(item.primaryText)
                .fontWeight(.bold)
              Text(item.secondaryText)
                .font(.caption)
            }
            if (item.value != nil) {
              Spacer()
              Text(item.value!)
            }
          }
            .padding(.vertical, dimensions.halfInterItemSpace.pt())
            .padding(.horizontal, dimensions.horizontalEdgeSpace.pt())
        }
      }
    }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
      .environmentObject(SharedDimensions())
	}
}
