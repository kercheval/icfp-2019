package icfp2019.analyzers

import icfp2019.core.Analyzer
import icfp2019.model.BoardCell
import icfp2019.model.GameState
import icfp2019.model.RobotId
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm
import org.jgrapht.alg.shortestpath.DijkstraShortestPath
import org.jgrapht.graph.DefaultEdge

object ShortestPathUsingDijkstra : Analyzer<ShortestPathAlgorithm<BoardCell, DefaultEdge>> {
    override fun analyze(initialState: GameState): (robotId: RobotId, state: GameState) -> ShortestPathAlgorithm<BoardCell, DefaultEdge> {
        val completeGraph = BoardCellsGraphAnalyzer.analyze(initialState)
        return { robotId, graphState ->
            val graph = completeGraph(robotId, graphState)
            DijkstraShortestPath(graph)
        }
    }
}
