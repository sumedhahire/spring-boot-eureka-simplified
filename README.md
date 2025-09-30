<!-- README snippet — paste into README.md -->
<h1>springboot-microservices-eureka-grpc-feign-tutorial</h1>

<!-- <p>
  <img src="assets/demo-gif.gif" alt="demo" width="720" />
</p>
 -->
<p>
  <img src="https://img.shields.io/badge/type-tutorial-green" alt="tutorial" />
  <img src="https://img.shields.io/badge/springboot-3.x-blue" alt="spring boot" />
  <img src="https://img.shields.io/badge/eureka-registered-yellow" alt="eureka" />
  <img src="https://img.shields.io/badge/grpc-supported-lightgrey" alt="grpc" />
  <img src="https://img.shields.io/badge/feign-client-blueviolet" alt="feign" />
</p>

<p>A compact hands-on tutorial (its simple rest assure). Two Spring Boot services register with Eureka and communicate using Feign (REST) and gRPC.</p>

<h2>Table of contents</h2>
<ul>
  <li><a href="#overview">Overview</a></li>
  <li><a href="#prerequisites">Prerequisites</a></li>
  <li><a href="#structure">Repo structure</a></li>
  <li><a href="#quickstart">Quickstart</a></li>
  <li><a href="#run-manually">Run manually</a></li>
  <li><a href="#test-examples">Test examples</a></li>
  <li><a href="#contributing">Contributing</a></li>
  <li><a href="#license">License</a></li>
</ul>

<hr/>

<h2 id="overview">Overview</h2>
<p>
  <strong>Notes on modules:</strong>
</p>
<p>
  <strong>Notes on modules:</strong>
</p>
<ul>
  <li><strong>common-lib</strong>: Shared models used by both gRPC and Feign clients for type consistency.</li>
  <li><strong>order</strong>: Provides REST and gRPC endpoints; also consumes endpoints from <strong>product</strong>.</li>
  <li><strong>product</strong>: Provides REST and gRPC endpoints; also consumes endpoints from <strong>order</strong>.</li>
  <li><strong>eureka-server</strong>: Handles service registration and discovery, enabling both applications to find each other dynamically.</li>
</ul>

<p>
  This design allows <strong>bidirectional communication</strong> between <strong>order</strong> and <strong>product</strong> via Feign (REST) and gRPC, with all shared data models maintained in <strong>common-lib</strong>.
</p>

<h2 id="prerequisites">Prerequisites</h2>
<ul>
  <li>Java 17+</li>
  <li>Maven 3.8+</li>
  <li>docker &amp; docker-compose (optional)</li>
  <li>grpcurl (optional)</li>
</ul>

<h2 id="structure">Repo structure</h2>
<pre><code>microservices/
├── eureka-server/
├── order/       # feign client + grpc client
├── product/       # rest + grpc server
└── common-proto/    # hello.proto
</code></pre>

<h2 id="quickstart">Quickstart (one-command)</h2>
<pre><code>git clone https://github.com/sumedhahire/spring-boot-eureka-simplified
./mvnw -pl eureka-service,order,product clean package -DskipTests
</code></pre>
<p>Eureka UI: <a href="http://localhost:8761">http://localhost:8761</a></p>

<h2 id="run-manually">Run manually</h2>
<ol>
  <li>Start Eureka:
    <pre><code>cd eureka-server
./mvnw spring-boot:run</code></pre>
  </li>
  <li>Start service-b (provider):
    <pre><code>cd ../product
./mvnw spring-boot:run</code></pre>
  </li>
  <li>Start service-a (consumer):
    <pre><code>cd ../order
./mvnw spring-boot:run</code></pre>
  </li>
</ol>

<h2 id="test-examples">Test examples</h2>
<h3>Feign (REST)</h3>
<pre><code>curl http://localhost:8080/hello/feign
# {"message":"Hello from service-b (rest)"}</code></pre>

<h3>gRPC</h3>
<pre><code>grpcurl -plaintext -d '{"name":"sumedh"}' localhost:9090 hello.HelloService/SayHello
# {"message":"Hello sumedh from gRPC"}</code></pre>

<h2 id="contributing">Contributing</h2>
<p>Use labels: <code>good first issue</code>, <code>enhancement</code>, <code>bug</code>. Keep PRs small and reference the step affected.</p>

<h2 id="license">License</h2>
<p>MIT. See <code>LICENSE</code>.</p>

<details>
  <summary>Notes</summary>
  <p>GitHub strips &lt;style&gt; and many attributes. This HTML uses supported tags only so it renders inside README.md. For a full HTML/CSS page host it via GitHub Pages and put the file in <code>/docs</code> or use the <code>gh-pages</code> branch.</p>
</details>
