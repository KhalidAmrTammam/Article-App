import Foundation
import shared

extension ArticlesScreen {
    @MainActor
    class ArticlesViewModelWrapper: ObservableObject {
        let articlesViewModel: ArticleViewModel

        @Published var articlesState: ArticleState

        init() {
            articlesViewModel = ArticleInjector().articleViewModel
            articlesState = articlesViewModel.articleState.value
        }

        func startObserving() {
            Task {
                for await state in articlesViewModel.articleStateFlow {
                    self.articlesState = state
                }
            }
        }
    }
}
