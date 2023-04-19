import com.mongodb.rx.client.MongoClients
import currency.ConverterProvider
import dao.MongoReactiveDao
import io.reactivex.netty.protocol.http.server.HttpServer
import query.Query

fun main() {
    val mongoUrl = "mongodb://localhost:27017"
    val dbName = "reactive"
    val dao = MongoReactiveDao(
        MongoClients.create(mongoUrl).getDatabase(dbName),
        ConverterProvider()
    )
    HttpServer.newServer(1000)
        .start { request, response ->
            val query = Query.fromRequest(request)
            response.writeString(query.process(dao).map { "$it\n" })
        }.awaitShutdown()
}