import SwiftUI
import shared

struct AppBar: View {
    var onAbout: () -> Void = {}

    var body: some View {
        HStack {
            Text("Articles App")
                .font(.headline)
            Spacer()
            Button(action: onAbout) {
                Image(systemName: "info.circle")
            }
        }
        .padding()
        .background(Color.blue)
        .foregroundColor(.white)
    }
}
