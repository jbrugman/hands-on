<!-- .slide: class="network-slide top-k-slide" -->
#### Top K: een vast aantal kandidaten

<div class="explainer-grid pipeline-explainer">
<div class="explainer-card pipeline-panel pipeline-input">
<h5>1. Tokens op volgorde van kans</h5>
<p>Na <strong>“de kat”</strong> krijgt elk mogelijk volgend token een kans. Sorteer van hoog naar laag.</p>
<div class="score-caption">Voorbeeldverdeling</div>
<table class="score-table"><thead><tr><th>Rang</th><th>Token</th><th>Kans</th></tr></thead><tbody><tr><td>1</td><td>ligt</td><td>60%</td></tr><tr><td>2</td><td>zit</td><td>25%</td></tr><tr><td>3</td><td>slaapt</td><td>10%</td></tr><tr><td>4</td><td>rent</td><td>5%</td></tr></tbody></table>
<div class="explainer-note"><strong>K bepaalt het aantal</strong><br>Behoud de K waarschijnlijkste tokens. Alle overige tokens vallen af.</div>
<p class="top-k-caption">Fictief voorbeeld met vier tokens en verschillende kansen. Houd temperature en andere samplinginstellingen hier gelijk.</p>
</div>

<div class="explainer-card pipeline-panel pipeline-network">
<h5>2. Alleen de eerste K blijven over</h5>
<p>De verdeling blijft hier gelijk. De stippellijn markeert de scheiding na kandidaat K. Grijze tokens vallen af.</p>
<svg class="top-k-chart" viewBox="0 0 740 420" role="img" aria-labelledby="top-k-title top-k-desc">
<title id="top-k-title">Top K behoudt de K waarschijnlijkste tokens</title>
<desc id="top-k-desc">De tokens ligt, zit, slaapt en rent staan gesorteerd op kans: 60, 25, 10 en 5 procent. Bij K is 1 blijft alleen ligt over. Bij K is 2 blijven ligt en zit over. Bij K is 3 blijven ligt, zit en slaapt over. Een stippellijn na de geselecteerde rang markeert de scheiding. Grijze balken vallen af.</desc>
<text x="0" y="22" fill="#4c8dff" font-size="22" font-weight="bold">K = 1</text><text x="155" y="22" fill="#ddd" font-size="19">Behoud de waarschijnlijkste kandidaat</text>
<text x="0" y="54" fill="#2dcd4d" font-size="19">ligt</text><rect x="90" y="38" width="480" height="18" rx="3" fill="#252525"/><rect x="90" y="38" width="480" height="18" rx="3" fill="#2dcd4d"/><text x="590" y="54" fill="#fff" font-size="19">60%</text><text x="655" y="54" fill="#2dcd4d" font-size="17">blijft</text>
<text x="0" y="77" fill="#999" font-size="19">zit</text><rect x="90" y="61" width="480" height="18" rx="3" fill="#252525"/><rect x="90" y="61" width="200" height="18" rx="3" fill="#666"/><text x="590" y="77" fill="#fff" font-size="19">25%</text><text x="655" y="77" fill="#999" font-size="17">valt af</text>
<text x="0" y="100" fill="#999" font-size="19">slaapt</text><rect x="90" y="84" width="480" height="18" rx="3" fill="#252525"/><rect x="90" y="84" width="80" height="18" rx="3" fill="#666"/><text x="590" y="100" fill="#fff" font-size="19">10%</text><text x="655" y="100" fill="#999" font-size="17">valt af</text>
<text x="0" y="123" fill="#999" font-size="19">rent</text><rect x="90" y="107" width="480" height="18" rx="3" fill="#252525"/><rect x="90" y="107" width="40" height="18" rx="3" fill="#666"/><text x="590" y="123" fill="#fff" font-size="19">5%</text><text x="655" y="123" fill="#999" font-size="17">valt af</text>
<path d="M0,58.5 H725" stroke="#fff" stroke-width="1.5" stroke-dasharray="5 4"/>
<text x="0" y="162" fill="#4c8dff" font-size="22" font-weight="bold">K = 2</text><text x="155" y="162" fill="#ddd" font-size="19">Behoud de 2 waarschijnlijkste kandidaten</text>
<text x="0" y="194" fill="#2dcd4d" font-size="19">ligt</text><rect x="90" y="178" width="480" height="18" rx="3" fill="#252525"/><rect x="90" y="178" width="480" height="18" rx="3" fill="#2dcd4d"/><text x="590" y="194" fill="#fff" font-size="19">60%</text><text x="655" y="194" fill="#2dcd4d" font-size="17">blijft</text>
<text x="0" y="217" fill="#4c8dff" font-size="19">zit</text><rect x="90" y="201" width="480" height="18" rx="3" fill="#252525"/><rect x="90" y="201" width="200" height="18" rx="3" fill="#4c8dff"/><text x="590" y="217" fill="#fff" font-size="19">25%</text><text x="655" y="217" fill="#4c8dff" font-size="17">blijft</text>
<text x="0" y="240" fill="#999" font-size="19">slaapt</text><rect x="90" y="224" width="480" height="18" rx="3" fill="#252525"/><rect x="90" y="224" width="80" height="18" rx="3" fill="#666"/><text x="590" y="240" fill="#fff" font-size="19">10%</text><text x="655" y="240" fill="#999" font-size="17">valt af</text>
<text x="0" y="263" fill="#999" font-size="19">rent</text><rect x="90" y="247" width="480" height="18" rx="3" fill="#252525"/><rect x="90" y="247" width="40" height="18" rx="3" fill="#666"/><text x="590" y="263" fill="#fff" font-size="19">5%</text><text x="655" y="263" fill="#999" font-size="17">valt af</text>
<path d="M0,221.5 H725" stroke="#fff" stroke-width="1.5" stroke-dasharray="5 4"/>
<text x="0" y="302" fill="#4c8dff" font-size="22" font-weight="bold">K = 3</text><text x="155" y="302" fill="#ddd" font-size="19">Behoud de 3 waarschijnlijkste kandidaten</text>
<text x="0" y="334" fill="#2dcd4d" font-size="19">ligt</text><rect x="90" y="318" width="480" height="18" rx="3" fill="#252525"/><rect x="90" y="318" width="480" height="18" rx="3" fill="#2dcd4d"/><text x="590" y="334" fill="#fff" font-size="19">60%</text><text x="655" y="334" fill="#2dcd4d" font-size="17">blijft</text>
<text x="0" y="357" fill="#4c8dff" font-size="19">zit</text><rect x="90" y="341" width="480" height="18" rx="3" fill="#252525"/><rect x="90" y="341" width="200" height="18" rx="3" fill="#4c8dff"/><text x="590" y="357" fill="#fff" font-size="19">25%</text><text x="655" y="357" fill="#4c8dff" font-size="17">blijft</text>
<text x="0" y="380" fill="#a66cff" font-size="19">slaapt</text><rect x="90" y="364" width="480" height="18" rx="3" fill="#252525"/><rect x="90" y="364" width="80" height="18" rx="3" fill="#a66cff"/><text x="590" y="380" fill="#fff" font-size="19">10%</text><text x="655" y="380" fill="#a66cff" font-size="17">blijft</text>
<text x="0" y="403" fill="#999" font-size="19">rent</text><rect x="90" y="387" width="480" height="18" rx="3" fill="#252525"/><rect x="90" y="387" width="40" height="18" rx="3" fill="#666"/><text x="590" y="403" fill="#fff" font-size="19">5%</text><text x="655" y="403" fill="#999" font-size="17">valt af</text>
<path d="M0,384.5 H725" stroke="#fff" stroke-width="1.5" stroke-dasharray="5 4"/>
</svg>
<div class="top-k-summary">K = 1: één kandidaat. K = 2: twee kandidaten. K = 3: drie.<span>De balken tonen de oorspronkelijke kansen, vóór het opnieuw normaliseren.</span></div>
</div>

<div class="explainer-card pipeline-panel pipeline-output">
<h5>3. Kiezen uit de top K</h5>
<p>Bij K = 2 blijven <strong>“ligt”</strong> en <strong>“zit”</strong> over. Hun oorspronkelijke kansen tellen op tot 85%.</p>
<div class="explainer-note"><strong>Opnieuw naar 100%</strong><br>ligt: 60 / 85 ≈ <strong>70,6%</strong><br>zit: 25 / 85 ≈ <strong>29,4%</strong><br>slaapt en rent: <strong>0%</strong></div>
<div class="explainer-note"><strong>Daarna een token trekken</strong><br>De software kiest volgens deze nieuwe kansen. “zit” blijft een mogelijke uitkomst.</div>
<div class="output-sentence"><strong>Mogelijke output bij K = 2</strong><div class="output-tokens"><span>de</span><span>kat</span><span class="predicted">zit</span></div></div>
<p class="top-k-caption">Lager K beperkt de keuze. Hoger K laat meer kandidaten toe. Bij K = 1 blijft alleen het waarschijnlijkste token over.</p>
</div>
</div>
