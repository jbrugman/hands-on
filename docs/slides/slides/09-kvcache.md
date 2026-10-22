<!-- .slide: class="network-slide kv-slide" -->
#### KV Cache Quantization: minder geheugen voor context

<div class="explainer-grid pipeline-explainer">
<div class="explainer-card pipeline-panel pipeline-input">
<h5>1. Wat bewaart de KV-cache?</h5>
<p>Het model bewaart Key- en Value-berekeningen van eerdere tokens voor hergebruik bij volgende tokens.</p>
<div class="explainer-note"><strong>K en V hergebruiken</strong><br>Zo hoeft het model die berekeningen voor eerdere tokens niet steeds opnieuw uit te voeren.</div>
<div class="explainer-note"><strong>Opslaan met minder bits</strong><br>Quantization bewaart de cachewaarden met lagere precisie. Dat verkleint hun opslag.</div>
<p class="kv-caption">Dit verandert de precisie van de KV-cache. De modelgewichten blijven gelijk.</p>
</div>

<div class="explainer-card pipeline-panel pipeline-network">
<h5>2. Dezelfde cache, minder bits</h5>
<p>Theoretische opslagverhouding voor hetzelfde aantal K/V-waarden. Beide cacheonderdelen krijgen hier dezelfde bitbreedte.</p>
<svg class="kv-chart" viewBox="0 0 740 420" role="img" aria-labelledby="kv-title kv-desc">
<title id="kv-title">Theoretische opslag voor dezelfde KV-cachewaarden op 16, 8 en 4 bits</title>
<desc id="kv-desc">Bij gelijk aantal tokens en dezelfde cachevorm is 16 bits de referentie met 100 procent opslag voor de waarden. 8 bits gebruikt theoretisch 50 procent en 4 bits 25 procent. Iedere balk heeft een groen deel voor Keys en een blauw deel voor Values. Grijs toont de besparing tegenover de referentie. Schaalfactoren, metadata en overige overhead tellen niet mee.</desc>
<text x="20" y="24" fill="#ddd" font-size="21">Zelfde tokens, lagen en aantal K/V-waarden</text>
<text x="20" y="62" fill="#4c8dff" font-size="22" font-weight="bold">16 bits per waarde</text><rect x="20" y="78" width="600" height="38" rx="4" fill="#333"/>
<rect x="20.0" y="78" width="300.0" height="38" fill="#2dcd4d" stroke="#111" stroke-width="2"/><text x="170.0" y="104" fill="#111" text-anchor="middle" font-size="21" font-weight="bold">K</text>
<rect x="320.0" y="78" width="300.0" height="38" fill="#4c8dff" stroke="#111" stroke-width="2"/><text x="470.0" y="104" fill="#111" text-anchor="middle" font-size="21" font-weight="bold">V</text>
<text x="640" y="104" fill="#fff" font-size="23" font-weight="bold">100%</text><text x="20" y="141" fill="#ddd" font-size="19">Referentie: hoogste precisie in deze vergelijking</text>
<text x="20" y="182" fill="#4c8dff" font-size="22" font-weight="bold">8 bits per waarde</text><rect x="20" y="198" width="600" height="38" rx="4" fill="#333"/>
<rect x="20.0" y="198" width="150.0" height="38" fill="#2dcd4d" stroke="#111" stroke-width="2"/><text x="95.0" y="224" fill="#111" text-anchor="middle" font-size="21" font-weight="bold">K</text>
<rect x="170.0" y="198" width="150.0" height="38" fill="#4c8dff" stroke="#111" stroke-width="2"/><text x="245.0" y="224" fill="#111" text-anchor="middle" font-size="21" font-weight="bold">V</text>
<text x="640" y="224" fill="#fff" font-size="23" font-weight="bold">50%</text><text x="20" y="261" fill="#ddd" font-size="19">Halve opslag voor de cachewaarden</text>
<text x="20" y="302" fill="#4c8dff" font-size="22" font-weight="bold">4 bits per waarde</text><rect x="20" y="318" width="600" height="38" rx="4" fill="#333"/>
<rect x="20.0" y="318" width="75.0" height="38" fill="#2dcd4d" stroke="#111" stroke-width="2"/><text x="57.5" y="344" fill="#111" text-anchor="middle" font-size="21" font-weight="bold">K</text>
<rect x="95.0" y="318" width="75.0" height="38" fill="#4c8dff" stroke="#111" stroke-width="2"/><text x="132.5" y="344" fill="#111" text-anchor="middle" font-size="21" font-weight="bold">V</text>
<text x="640" y="344" fill="#fff" font-size="23" font-weight="bold">25%</text><text x="20" y="381" fill="#ddd" font-size="19">Een kwart van de opslag voor de cachewaarden</text>
<text x="20" y="412" fill="#2dcd4d" font-size="19">K = Keys</text><text x="200" y="412" fill="#4c8dff" font-size="19">V = Values</text><text x="390" y="412" fill="#aaa" font-size="19">Grijs = bespaarde waardeopslag</text></svg>
<div class="kv-summary">16 bits: 100%. 8 bits: 50%. 4 bits: 25%.<span>Alleen waardeopslag, zonder schaalfactoren, metadata en andere overhead. Geen totaal RAM/VRAM.</span></div>
</div>

<div class="explainer-card pipeline-panel pipeline-output">
<h5>3. Geheugen versus precisie</h5>
<p>Minder cachegeheugen kan ruimte geven voor langere context of meer gelijktijdige requests.</p>
<div class="explainer-note"><strong>Kwaliteit kan veranderen</strong><br>Lagere precisie introduceert afrondfouten. Het effect verschilt per model, taak en quantizationmethode.</div>
<div class="explainer-note"><strong>Niet automatisch sneller</strong><br>Omzetten kost rekenwerk. Bij korte context en genoeg geheugen kan quantization juist vertragen.</div>
<p class="kv-caption">Ondersteuning verschilt per model en runtime. Soms zijn K en V apart instelbaar. Controleer kwaliteit én snelheid.</p>
</div>
</div>
