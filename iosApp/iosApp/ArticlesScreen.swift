import SwiftUI
import shared

struct ArticlesScreen: View {
    @StateObject var viewModel = ArticlesViewModelWrapper()
    
    var body: some View {
        VStack {
            AppBar()
            
            if viewModel.articlesState.isLoading {
                ProgressView()
            }
            
            if !viewModel.articlesState.error.isEmpty {
                Text(viewModel.articlesState.error)
                    .foregroundColor(.red)
            }
            
            if !viewModel.articlesState.articles.isEmpty {
                ScrollView {
                    LazyVStack(spacing: 10) {
                        ForEach(viewModel.articlesState.articles, id: \.self) { article in
                            ArticleItemView(article: article)
                        }
                    }
                    .padding()
                }
            }
        }
        .onAppear {
            viewModel.startObserving()
        }
    }
}
