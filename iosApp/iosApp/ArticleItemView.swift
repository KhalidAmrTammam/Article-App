import SwiftUI
import shared

struct ArticleItemView: View {
    var article: ArticleRow

    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            AsyncImage(url: URL(string: article.imageUrl)) { phase in
                if let image = phase.image {
                    image
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                } else if phase.error != nil {
                    Text("Image Load Error")
                } else {
                    ProgressView()
                }
            }
            Text(article.title)
                .font(.title2)
                .fontWeight(.bold)
            Text(article.desc_)
            Text(article.date)
                .frame(maxWidth: .infinity, alignment: .trailing)
                .foregroundStyle(.gray)
        }
        .padding()
        .background(Color(UIColor.systemBackground))
        .cornerRadius(10)
        .shadow(radius: 2)
    }
}
