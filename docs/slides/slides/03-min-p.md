<!-- .slide: class="network-slide min-p-slide" -->
#### Min P: een relatieve kansdrempel

<div class="explainer-grid pipeline-explainer">
<div class="explainer-card pipeline-panel pipeline-input">
<h5>1. De hoogste kans als basis</h5>
<p>Na <strong>“de kat”</strong> krijgt elk mogelijk volgend token een kans. Het waarschijnlijkste token vormt de referentie.</p>
<div class="score-caption">Voorbeeldverdeling</div>
<table class="score-table"><thead><tr><th>Token</th><th>Kans</th></tr></thead><tbody><tr class="winner"><td>ligt</td><td>60%</td></tr><tr><td>zit</td><td>25%</td></tr><tr><td>slaapt</td><td>10%</td></tr><tr><td>rent</td><td>5%</td></tr></tbody></table>
<div class="explainer-note"><strong>Drempel = Min P × hoogste kans</strong><br>Een token blijft over als zijn kans minstens deze drempel is.</div>
<p class="min-p-caption">Fictief voorbeeld met vier tokens. Houd temperature en andere samplinginstellingen hier gelijk.</p>
</div>

<div class="explainer-card pipeline-panel pipeline-network">
<h5>2. Tokens onder de drempel vallen af</h5>
<p>De hoogste kans blijft hier 60%. Een hogere Min P legt de drempel hoger en filtert meer tokens weg.</p>
<svg class="min-p-chart" viewBox="0 0 740 420" role="img" aria-labelledby="min-p-title min-p-desc">
<title id="min-p-title">Min P stelt een drempel ten opzichte van het waarschijnlijkste token</title>
<desc id="min-p-desc">De tokens ligt, zit, slaapt en rent hebben kansen van 60, 25, 10 en 5 procent. De hoogste kans is 60 procent. Bij Min P 0,10 is de drempel 6 procent en valt rent af. Bij 0,20 is de drempel 12 procent en vallen slaapt en rent af. Bij 0,50 is de drempel 30 procent en blijft alleen ligt over. De stippellijn toont de drempel, grijze balken vallen af.</desc>
<text x="0" y="22" fill="#4c8dff" font-size="22" font-weight="bold">Min P = 0,10</text><text x="235" y="22" fill="#ddd" font-size="19">Drempel: 0,10 × 60% = 6%</text>
<text x="0" y="54" fill="#2dcd4d" font-size="19">ligt</text><rect x="90" y="38" width="480" height="18" rx="3" fill="#252525"/><rect x="90" y="38" width="480" height="18" rx="3" fill="#2dcd4d"/><text x="590" y="54" fill="#fff" font-size="19">60%</text><text x="655" y="54" fill="#2dcd4d" font-size="17">blijft</text>
<text x="0" y="77" fill="#4c8dff" font-size="19">zit</text><rect x="90" y="61" width="480" height="18" rx="3" fill="#252525"/><rect x="90" y="61" width="200" height="18" rx="3" fill="#4c8dff"/><text x="590" y="77" fill="#fff" font-size="19">25%</text><text x="655" y="77" fill="#4c8dff" font-size="17">blijft</text>
<text x="0" y="100" fill="#a66cff" font-size="19">slaapt</text><rect x="90" y="84" width="480" height="18" rx="3" fill="#252525"/><rect x="90" y="84" width="80" height="18" rx="3" fill="#a66cff"/><text x="590" y="100" fill="#fff" font-size="19">10%</text><text x="655" y="100" fill="#a66cff" font-size="17">blijft</text>
<text x="0" y="123" fill="#999" font-size="19">rent</text><rect x="90" y="107" width="480" height="18" rx="3" fill="#252525"/><rect x="90" y="107" width="40" height="18" rx="3" fill="#666"/><text x="590" y="123" fill="#fff" font-size="19">5%</text><text x="655" y="123" fill="#999" font-size="17">valt af</text>
<path d="M138.0,31 V129" stroke="#fff" stroke-width="2" stroke-dasharray="5 4"/>
<text x="0" y="162" fill="#4c8dff" font-size="22" font-weight="bold">Min P = 0,20</text><text x="235" y="162" fill="#ddd" font-size="19">Drempel: 0,20 × 60% = 12%</text>
<text x="0" y="194" fill="#2dcd4d" font-size="19">ligt</text><rect x="90" y="178" width="480" height="18" rx="3" fill="#252525"/><rect x="90" y="178" width="480" height="18" rx="3" fill="#2dcd4d"/><text x="590" y="194" fill="#fff" font-size="19">60%</text><text x="655" y="194" fill="#2dcd4d" font-size="17">blijft</text>
<text x="0" y="217" fill="#4c8dff" font-size="19">zit</text><rect x="90" y="201" width="480" height="18" rx="3" fill="#252525"/><rect x="90" y="201" width="200" height="18" rx="3" fill="#4c8dff"/><text x="590" y="217" fill="#fff" font-size="19">25%</text><text x="655" y="217" fill="#4c8dff" font-size="17">blijft</text>
<text x="0" y="240" fill="#999" font-size="19">slaapt</text><rect x="90" y="224" width="480" height="18" rx="3" fill="#252525"/><rect x="90" y="224" width="80" height="18" rx="3" fill="#666"/><text x="590" y="240" fill="#fff" font-size="19">10%</text><text x="655" y="240" fill="#999" font-size="17">valt af</text>
<text x="0" y="263" fill="#999" font-size="19">rent</text><rect x="90" y="247" width="480" height="18" rx="3" fill="#252525"/><rect x="90" y="247" width="40" height="18" rx="3" fill="#666"/><text x="590" y="263" fill="#fff" font-size="19">5%</text><text x="655" y="263" fill="#999" font-size="17">valt af</text>
<path d="M186.0,171 V269" stroke="#fff" stroke-width="2" stroke-dasharray="5 4"/>
<text x="0" y="302" fill="#4c8dff" font-size="22" font-weight="bold">Min P = 0,50</text><text x="235" y="302" fill="#ddd" font-size="19">Drempel: 0,50 × 60% = 30%</text>
<text x="0" y="334" fill="#2dcd4d" font-size="19">ligt</text><rect x="90" y="318" width="480" height="18" rx="3" fill="#252525"/><rect x="90" y="318" width="480" height="18" rx="3" fill="#2dcd4d"/><text x="590" y="334" fill="#fff" font-size="19">60%</text><text x="655" y="334" fill="#2dcd4d" font-size="17">blijft</text>
<text x="0" y="357" fill="#999" font-size="19">zit</text><rect x="90" y="341" width="480" height="18" rx="3" fill="#252525"/><rect x="90" y="341" width="200" height="18" rx="3" fill="#666"/><text x="590" y="357" fill="#fff" font-size="19">25%</text><text x="655" y="357" fill="#999" font-size="17">valt af</text>
<text x="0" y="380" fill="#999" font-size="19">slaapt</text><rect x="90" y="364" width="480" height="18" rx="3" fill="#252525"/><rect x="90" y="364" width="80" height="18" rx="3" fill="#666"/><text x="590" y="380" fill="#fff" font-size="19">10%</text><text x="655" y="380" fill="#999" font-size="17">valt af</text>
<text x="0" y="403" fill="#999" font-size="19">rent</text><rect x="90" y="387" width="480" height="18" rx="3" fill="#252525"/><rect x="90" y="387" width="40" height="18" rx="3" fill="#666"/><text x="590" y="403" fill="#fff" font-size="19">5%</text><text x="655" y="403" fill="#999" font-size="17">valt af</text>
<path d="M330.0,311 V409" stroke="#fff" stroke-width="2" stroke-dasharray="5 4"/>
</svg>
<div class="min-p-summary">Gekleurd blijft over. Grijs valt af.<span>De stippellijn is de drempel. Alle balken gebruiken dezelfde schaal.</span></div>
</div>

<div class="explainer-card pipeline-panel pipeline-output">
<h5>3. Kiezen na het filter</h5>
<p>Bij Min P = 0,20 is de drempel <strong>12%</strong>. Alleen <strong>“ligt”</strong> en <strong>“zit”</strong> blijven over, samen 85%.</p>
<div class="explainer-note"><strong>Opnieuw naar 100%</strong><br>ligt: 60 / 85 ≈ <strong>70,6%</strong><br>zit: 25 / 85 ≈ <strong>29,4%</strong><br>slaapt en rent: <strong>0%</strong></div>
<div class="explainer-note"><strong>Daarna een token trekken</strong><br>De software kiest volgens deze nieuwe kansen. “zit” blijft een mogelijke uitkomst.</div>
<div class="output-sentence"><strong>Mogelijke output bij Min P = 0,20</strong><div class="output-tokens"><span>de</span><span>kat</span><span class="predicted">zit</span></div></div>
<p class="min-p-caption">Hoger Min P filtert strenger. Bij een volgende stap verandert de hoogste kans, en dus ook de drempel.</p>
</div>
</div>
