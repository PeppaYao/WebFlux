### WebFlux
WebFlux可以作为Spring MVC的替代方案，以异步非阻塞的方式实现编程，从而提高系统性能。
- Flux: 0~N个元素序列
- Mono：0~1个元素序列
- StepVerifier：单步验证
### 优势
- web MVC技术使用的是同步阻塞IO模型，即一个request对应一个容器中的线程。有超过容器中工作线程的请求到达时，就会block住，这样客户端就得不到及时的响应。
- webflux使用异步非阻塞式IO模型
- callback hell
- 调用future的get仍然会阻塞

### reactor和stream
- reactor是push模式,服务端推送数据给客户端
- stream是pull模式，客户端主动向服务端请求数据
### 背压backpressure
- 只对flux有意义。对于客户端，有时候响应能力和服务端有很大的差距，如果在短时间内服务端将大量的数据流传输给客户端，客户端就可能被压垮。
为了处理这个问题，一般会考虑使用响应式拉取，也就是将服务端的数据流划分为多个序列，一次仅发送一个数据流序列给客户端，当客户端处理完这个序列后，
再给服务端发送消息，然后再拉取第二个序列进行处理。