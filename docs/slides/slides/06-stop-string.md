<!-- .slide: class="network-slide stop-slide" -->
#### Stop string: generatie beëindigen

<div class="explainer-grid pipeline-explainer">
<div class="explainer-card pipeline-panel pipeline-input">
<h5>1. Server stelt de grens in</h5>
<p>Je server vraagt een antwoord aan bij de lokale runtime en geeft vooraf een stop string mee.</p>
<div class="score-caption">Voorbeeldinstellingen in het request</div>
<pre class="stop-request"><code class="language-json">{
  "stream": true,
  "stop": ["&lt;END_REPLY&gt;"]
}</code></pre>
<div class="explainer-note"><strong>Afspraak in de prompt</strong><br>“Sluit je antwoord af met <code>&lt;END_REPLY&gt;</code>.”</div>
<p class="stop-caption">Schematisch request. Ondersteuning en veldnamen verschillen per API en runtime.</p>
</div>

<div class="explainer-card pipeline-panel pipeline-network">
<h5>2. Stopmarker herkennen</h5>
<p>De runtime controleert de tekst terwijl het model genereert. De volledige stop string kan over meerdere stukken verdeeld zijn.</p>
<svg class="stop-chart" viewBox="0 0 740 420" role="img" aria-labelledby="stop-title stop-desc">
<title id="stop-title">Stop string herkennen en de antwoordstream afronden</title>
<desc id="stop-desc">De runtime genereert schematisch de stukken Hallo, komma wereld punt, kleiner-dan END underscore en REPLY groter-dan. De laatste twee stukken vormen samen de stop string END_REPLY tussen punthaken. De runtime houdt de mogelijke marker achter, herkent de complete marker en stopt de generatie. Alleen Hallo, wereld. gaat via de server naar de client. De marker wordt in dit voorbeeld niet meegestuurd.</desc>
<text x="15" y="25" fill="#4c8dff" font-size="21" font-weight="bold">1. Interne uitvoer van de runtime (schematisch)</text>
<g font-family="monospace" font-size="22" text-anchor="middle">
<rect x="15" y="45" width="130" height="50" rx="8" fill="#152a18" stroke="#2dcd4d" stroke-width="2"/><text x="80" y="77" fill="#2dcd4d">Hallo</text>
<rect x="160" y="45" width="205" height="50" rx="8" fill="#152a18" stroke="#2dcd4d" stroke-width="2"/><text x="262.5" y="77" fill="#2dcd4d">, wereld.</text>
<rect x="380" y="45" width="150" height="50" rx="8" fill="#302115" stroke="#ff8a33" stroke-width="2"/><text x="455" y="77" fill="#ff8a33">&lt;END_</text>
<rect x="545" y="45" width="180" height="50" rx="8" fill="#302115" stroke="#ff8a33" stroke-width="2"/><text x="635" y="77" fill="#ff8a33">REPLY&gt;</text>
</g>
<path d="M380 103 V112 H725 V103" fill="none" stroke="#ff8a33" stroke-width="2"/>
<text x="552.5" y="135" text-anchor="middle" fill="#ff8a33" font-size="18">Samen één stop string</text>
<text x="15" y="180" fill="#4c8dff" font-size="21" font-weight="bold">2. Stopcontrole herkent de volledige marker</text>
<rect x="15" y="198" width="710" height="63" rx="10" fill="#151c27" stroke="#355273" stroke-width="2"/>
<text x="370" y="224" text-anchor="middle" fill="#fff" font-size="20">Mogelijke marker bufferen, daarna matchen</text>
<text x="370" y="247" text-anchor="middle" fill="#ff8a33" font-size="20" font-family="monospace">&lt;END_ + REPLY&gt; = &lt;END_REPLY&gt;</text>
<text x="15" y="305" fill="#4c8dff" font-size="21" font-weight="bold">3. Generatie stopt, antwoordstream wordt afgerond</text>
<rect x="15" y="323" width="455" height="53" rx="8" fill="#152a18" stroke="#2dcd4d" stroke-width="2"/>
<text x="242.5" y="357" text-anchor="middle" fill="#2dcd4d" font-size="25">Hallo, wereld.</text>
<rect x="485" y="323" width="240" height="53" rx="8" fill="#28193d" stroke="#a66cff" stroke-width="2"/>
<text x="605" y="356" text-anchor="middle" fill="#a66cff" font-size="22">Antwoord klaar</text>
<text x="370" y="407" text-anchor="middle" fill="#ddd" font-size="19">Naar de client: het antwoord, zonder de stopmarker</text>
</svg>
<div class="stop-summary">Runtime stopt generatie. Server sluit de antwoordstream af.<span>Dit voorbeeld gebruikt een runtime die de stop string uit de antwoordtekst weglaat.</span></div>
</div>

<div class="explainer-card pipeline-panel pipeline-output">
<h5>3. Handig voor tooling</h5>
<p>Je server streamt de reply door naar de client. Met een afgesproken marker kun je de antwoordgrens bewaken.</p>
<div class="explainer-note"><strong>Vooraf meegeven</strong><br>De stop string is een generatie-instelling in het request. De runtime stopt wanneer het model die tekst produceert.</div>
<div class="explainer-note"><strong>Marker moet verschijnen</strong><br>Een stop string dwingt het model niet om die tekst te schrijven. Houd ook een tokenlimiet aan.</div>
<p class="stop-caption">Kies een onderscheidende marker. Als deze in gewone antwoordtekst voorkomt, kan de generatie te vroeg stoppen.</p>
</div>
</div>
