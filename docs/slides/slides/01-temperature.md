<!-- .slide: class="network-slide temperature-slide" -->
#### Temperature bij een lokaal LLM

<div class="explainer-grid pipeline-explainer">
<div class="explainer-card pipeline-panel pipeline-input">
<h5>1. Mogelijke volgende tokens</h5>
<p>Na <strong>“de kat”</strong> geeft het model elk mogelijk volgend token een score (logit).</p>
<div class="score-caption">Voorbeeldscores uit het model</div>
<table class="score-table"><thead><tr><th>Token</th><th>Score</th></tr></thead><tbody><tr><td>ligt</td><td>3,0</td></tr><tr><td>zit</td><td>2,0</td></tr><tr><td>slaapt</td><td>1,0</td></tr><tr><td>rent</td><td>0,0</td></tr></tbody></table>
<div class="explainer-note"><strong>Dezelfde modelscores</strong><br>Temperature verandert de kansen voor de tokenkeuze. De modelgewichten blijven gelijk.</div>
<p class="temperature-caption">Vereenvoudigd voorbeeld met vier tokens. Een echt model heeft een veel grotere woordenschat.</p>
</div>

<div class="explainer-card pipeline-panel pipeline-network">
<h5>2. Temperature: van scores naar kansen</h5>
<p>Deel elke score door T en zet de uitkomsten met softmax om naar kansen. De balklengte toont de kans per token.</p>
<svg class="temperature-chart" viewBox="0 0 740 420" role="img" aria-labelledby="temperature-chart-title temperature-chart-desc">
<title id="temperature-chart-title">Dezelfde tokens, andere kansen door temperature</title>
<desc id="temperature-chart-desc">Voor de tokens ligt, zit, slaapt en rent blijven de modelscores 3, 2, 1 en 0. Bij temperature 0,5 krijgt ligt ongeveer 86 procent kans, bij 1,0 ongeveer 64 procent en bij 1,5 ongeveer 52 procent. De overige tokens krijgen bij hogere temperature meer kans.</desc>
<text x="0" y="22" fill="#4c8dff" font-size="22" font-weight="bold">T = 0,5</text><text x="145" y="22" fill="#ddd" font-size="18">Sterkere voorkeur voor de hoogste score</text>
<text x="0" y="54" fill="#2dcd4d" font-size="19">ligt</text><rect x="90" y="38" width="540" height="18" rx="3" fill="#252525"/><rect x="90" y="38" width="467.076" height="18" rx="3" fill="#2dcd4d"/><text x="645" y="54" fill="#fff" font-size="19">86,5%</text>
<text x="0" y="77" fill="#4c8dff" font-size="19">zit</text><rect x="90" y="61" width="540" height="18" rx="3" fill="#252525"/><rect x="90" y="61" width="63.212" height="18" rx="3" fill="#4c8dff"/><text x="645" y="77" fill="#fff" font-size="19">11,7%</text>
<text x="0" y="100" fill="#a66cff" font-size="19">slaapt</text><rect x="90" y="84" width="540" height="18" rx="3" fill="#252525"/><rect x="90" y="84" width="8.555" height="18" rx="3" fill="#a66cff"/><text x="645" y="100" fill="#fff" font-size="19">1,6%</text>
<text x="0" y="123" fill="#ff8a33" font-size="19">rent</text><rect x="90" y="107" width="540" height="18" rx="3" fill="#252525"/><rect x="90" y="107" width="1.158" height="18" rx="3" fill="#ff8a33"/><text x="645" y="123" fill="#fff" font-size="19">0,2%</text>
<text x="0" y="162" fill="#4c8dff" font-size="22" font-weight="bold">T = 1,0</text><text x="145" y="162" fill="#ddd" font-size="18">Kansen uit de oorspronkelijke scores</text>
<text x="0" y="194" fill="#2dcd4d" font-size="19">ligt</text><rect x="90" y="178" width="540" height="18" rx="3" fill="#252525"/><rect x="90" y="178" width="347.714" height="18" rx="3" fill="#2dcd4d"/><text x="645" y="194" fill="#fff" font-size="19">64,4%</text>
<text x="0" y="217" fill="#4c8dff" font-size="19">zit</text><rect x="90" y="201" width="540" height="18" rx="3" fill="#252525"/><rect x="90" y="201" width="127.917" height="18" rx="3" fill="#4c8dff"/><text x="645" y="217" fill="#fff" font-size="19">23,7%</text>
<text x="0" y="240" fill="#a66cff" font-size="19">slaapt</text><rect x="90" y="224" width="540" height="18" rx="3" fill="#252525"/><rect x="90" y="224" width="47.058" height="18" rx="3" fill="#a66cff"/><text x="645" y="240" fill="#fff" font-size="19">8,7%</text>
<text x="0" y="263" fill="#ff8a33" font-size="19">rent</text><rect x="90" y="247" width="540" height="18" rx="3" fill="#252525"/><rect x="90" y="247" width="17.312" height="18" rx="3" fill="#ff8a33"/><text x="645" y="263" fill="#fff" font-size="19">3,2%</text>
<text x="0" y="302" fill="#4c8dff" font-size="22" font-weight="bold">T = 1,5</text><text x="145" y="302" fill="#ddd" font-size="18">Meer kans voor de alternatieven</text>
<text x="0" y="334" fill="#2dcd4d" font-size="19">ligt</text><rect x="90" y="318" width="540" height="18" rx="3" fill="#252525"/><rect x="90" y="318" width="282.375" height="18" rx="3" fill="#2dcd4d"/><text x="645" y="334" fill="#fff" font-size="19">52,3%</text>
<text x="0" y="357" fill="#4c8dff" font-size="19">zit</text><rect x="90" y="341" width="540" height="18" rx="3" fill="#252525"/><rect x="90" y="341" width="144.976" height="18" rx="3" fill="#4c8dff"/><text x="645" y="357" fill="#fff" font-size="19">26,8%</text>
<text x="0" y="380" fill="#a66cff" font-size="19">slaapt</text><rect x="90" y="364" width="540" height="18" rx="3" fill="#252525"/><rect x="90" y="364" width="74.433" height="18" rx="3" fill="#a66cff"/><text x="645" y="380" fill="#fff" font-size="19">13,8%</text>
<text x="0" y="403" fill="#ff8a33" font-size="19">rent</text><rect x="90" y="387" width="540" height="18" rx="3" fill="#252525"/><rect x="90" y="387" width="38.215" height="18" rx="3" fill="#ff8a33"/><text x="645" y="403" fill="#fff" font-size="19">7,1%</text>
</svg>
<div class="temperature-formula">kans(token) = softmax(score / T) <span>Voor T &gt; 0, zonder andere samplingfilters</span></div>
</div>

<div class="explainer-card pipeline-panel pipeline-output">
<h5>3. Een token kiezen</h5>
<p>Bij sampling trekt de software één token volgens deze kansen. Ook een token met een lagere score kan aan de beurt komen.</p>
<div class="explainer-note"><strong>Lagere T</strong><br>Sterkere voorkeur voor de waarschijnlijkste tokens. Meestal minder variatie.</div>
<div class="explainer-note"><strong>Hogere T</strong><br>Meer ruimte voor alternatieven. Meestal meer variatie, ook meer kans op onlogische tekst.</div>
<div class="output-sentence"><strong>Mogelijke output bij deze stap</strong><div class="output-tokens"><span>de</span><span>kat</span><span class="predicted">zit</span></div></div>
<p class="temperature-caption">Een lagere T garandeert geen correct antwoord. Geschikte waarden verschillen per model.</p>
</div>
</div>
