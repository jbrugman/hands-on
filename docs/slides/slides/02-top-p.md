<!-- .slide: class="network-slide nucleus-slide" -->
#### Top P: nucleus sampling

<div class="explainer-grid pipeline-explainer">
<div class="explainer-card pipeline-panel pipeline-input">
<h5>1. Tokens op volgorde van kans</h5>
<p>Na <strong>“de kat”</strong> krijgt elk mogelijk volgend token een kans. Sorteer van hoog naar laag.</p>
<div class="score-caption">Voorbeeldverdeling</div>
<table class="score-table"><thead><tr><th>Token</th><th>Kans</th><th>Opgeteld</th></tr></thead><tbody><tr><td>ligt</td><td>60%</td><td>60%</td></tr><tr><td>zit</td><td>25%</td><td>85%</td></tr><tr><td>slaapt</td><td>10%</td><td>95%</td></tr><tr><td>rent</td><td>5%</td><td>100%</td></tr></tbody></table>
<div class="explainer-note"><strong>De nucleus</strong><br>De kleinste groep waarschijnlijkste tokens waarvan de kansen samen minstens P zijn.</div>
<p class="nucleus-caption">Fictief voorbeeld met vier tokens. Houd temperature en andere samplinginstellingen hier gelijk.</p>
</div>

<div class="explainer-card pipeline-panel pipeline-network">
<h5>2. Optellen tot de Top P-grens</h5>
<p>Neem tokens mee tot de opgetelde kans de grens bereikt of overschrijdt. Het token dat de grens passeert, blijft erbij.</p>
<svg class="nucleus-chart" viewBox="0 0 740 420" role="img" aria-labelledby="nucleus-title nucleus-desc">
<title id="nucleus-title">Top P selecteert tokens op hun opgetelde kans</title>
<desc id="nucleus-desc">De tokens ligt, zit, slaapt en rent hebben kansen van 60, 25, 10 en 5 procent. Top P 0,50 behoudt ligt met 60 procent totale kans. Top P 0,80 behoudt ligt en zit met samen 85 procent. Top P 0,90 behoudt ook slaapt met samen 95 procent. Een stippellijn toont de ingestelde grens. Grijze segmenten vallen af.</desc>
<text x="0" y="23" fill="#4c8dff" font-size="22" font-weight="bold">P = 0,50</text>
<text x="155" y="23" fill="#ddd" font-size="19">1 token behouden, samen 60%</text>
<rect x="35.0" y="47" width="390.0" height="38" fill="#2dcd4d" stroke="#111" stroke-width="2"/><text x="230.00" y="72" text-anchor="middle" fill="#111" font-size="17" font-weight="bold">60%</text>
<rect x="425.0" y="47" width="162.5" height="38" fill="#383838" stroke="#111" stroke-width="2"/><text x="506.25" y="72" text-anchor="middle" fill="#aaa" font-size="17" font-weight="bold">25%</text>
<rect x="587.5" y="47" width="65.0" height="38" fill="#383838" stroke="#111" stroke-width="2"/><text x="620.00" y="72" text-anchor="middle" fill="#aaa" font-size="17" font-weight="bold">10%</text>
<rect x="652.5" y="47" width="32.5" height="38" fill="#383838" stroke="#111" stroke-width="2"/><text x="668.75" y="72" text-anchor="middle" fill="#aaa" font-size="17" font-weight="bold">5%</text>
<path d="M360.0,33 V94" stroke="#fff" stroke-width="2" stroke-dasharray="5 4"/><text x="360.0" y="113" text-anchor="middle" fill="#fff" font-size="17">grens 50%</text>
<path d="M35,90 H425.0" stroke="#2dcd4d" stroke-width="3"/>
<text x="0" y="148" fill="#4c8dff" font-size="22" font-weight="bold">P = 0,80</text>
<text x="155" y="148" fill="#ddd" font-size="19">2 tokens behouden, samen 85%</text>
<rect x="35.0" y="172" width="390.0" height="38" fill="#2dcd4d" stroke="#111" stroke-width="2"/><text x="230.00" y="197" text-anchor="middle" fill="#111" font-size="17" font-weight="bold">60%</text>
<rect x="425.0" y="172" width="162.5" height="38" fill="#4c8dff" stroke="#111" stroke-width="2"/><text x="506.25" y="197" text-anchor="middle" fill="#111" font-size="17" font-weight="bold">25%</text>
<rect x="587.5" y="172" width="65.0" height="38" fill="#383838" stroke="#111" stroke-width="2"/><text x="620.00" y="197" text-anchor="middle" fill="#aaa" font-size="17" font-weight="bold">10%</text>
<rect x="652.5" y="172" width="32.5" height="38" fill="#383838" stroke="#111" stroke-width="2"/><text x="668.75" y="197" text-anchor="middle" fill="#aaa" font-size="17" font-weight="bold">5%</text>
<path d="M555.0,158 V219" stroke="#fff" stroke-width="2" stroke-dasharray="5 4"/><text x="555.0" y="238" text-anchor="middle" fill="#fff" font-size="17">grens 80%</text>
<path d="M35,215 H587.5" stroke="#2dcd4d" stroke-width="3"/>
<text x="0" y="273" fill="#4c8dff" font-size="22" font-weight="bold">P = 0,90</text>
<text x="155" y="273" fill="#ddd" font-size="19">3 tokens behouden, samen 95%</text>
<rect x="35.0" y="297" width="390.0" height="38" fill="#2dcd4d" stroke="#111" stroke-width="2"/><text x="230.00" y="322" text-anchor="middle" fill="#111" font-size="17" font-weight="bold">60%</text>
<rect x="425.0" y="297" width="162.5" height="38" fill="#4c8dff" stroke="#111" stroke-width="2"/><text x="506.25" y="322" text-anchor="middle" fill="#111" font-size="17" font-weight="bold">25%</text>
<rect x="587.5" y="297" width="65.0" height="38" fill="#a66cff" stroke="#111" stroke-width="2"/><text x="620.00" y="322" text-anchor="middle" fill="#111" font-size="17" font-weight="bold">10%</text>
<rect x="652.5" y="297" width="32.5" height="38" fill="#383838" stroke="#111" stroke-width="2"/><text x="668.75" y="322" text-anchor="middle" fill="#aaa" font-size="17" font-weight="bold">5%</text>
<path d="M620.0,283 V344" stroke="#fff" stroke-width="2" stroke-dasharray="5 4"/><text x="620.0" y="363" text-anchor="middle" fill="#fff" font-size="17">grens 90%</text>
<path d="M35,340 H652.5" stroke="#2dcd4d" stroke-width="3"/>
<circle cx="42" cy="395" r="6" fill="#2dcd4d"/><text x="58" y="402" fill="#ddd" font-size="20">ligt</text>
<circle cx="212" cy="395" r="6" fill="#4c8dff"/><text x="228" y="402" fill="#ddd" font-size="20">zit</text>
<circle cx="382" cy="395" r="6" fill="#a66cff"/><text x="398" y="402" fill="#ddd" font-size="20">slaapt</text>
<circle cx="552" cy="395" r="6" fill="#ff8a33"/><text x="568" y="402" fill="#ddd" font-size="20">rent</text>
</svg>
<div class="nucleus-summary">Gekleurd blijft over. Grijs valt af.<span>De stippellijn is P. De groene lijn markeert de geselecteerde groep.</span></div>
</div>

<div class="explainer-card pipeline-panel pipeline-output">
<h5>3. Kiezen uit de nucleus</h5>
<p>Bij P = 0,80 blijven <strong>“ligt”</strong> en <strong>“zit”</strong> over. Hun oorspronkelijke kansen tellen op tot 85%.</p>
<div class="explainer-note"><strong>Opnieuw naar 100%</strong><br>ligt: 60 / 85 ≈ <strong>70,6%</strong><br>zit: 25 / 85 ≈ <strong>29,4%</strong><br>slaapt en rent: <strong>0%</strong></div>
<div class="explainer-note"><strong>Daarna een token trekken</strong><br>De software kiest volgens deze nieuwe kansen. “zit” blijft dus een mogelijke uitkomst.</div>
<div class="output-sentence"><strong>Mogelijke output bij P = 0,80</strong><div class="output-tokens"><span>de</span><span>kat</span><span class="predicted">zit</span></div></div>
<p class="nucleus-caption">Lagere P beperkt de keuze. Hogere P laat meer alternatieven toe. P = 1 laat alle tokens met positieve kans toe.</p>
</div>
</div>
