<!-- .slide: class="network-slide context-slide" -->
#### Context Length: hoeveel tekst past erin?

<div class="explainer-grid pipeline-explainer">
<div class="explainer-card pipeline-panel pipeline-input">
<h5>1. Wat telt mee?</h5>
<p>Context Length is het tokenbudget voor de invoer en het gegenereerde antwoord samen.</p>
<div class="explainer-note"><strong>Invoer</strong><br>Systeemprompt, gespreksgeschiedenis, documenten, toolresultaten en de huidige vraag.</div>
<div class="explainer-note"><strong>Uitvoer</strong><br>Ook het nieuwe antwoord gebruikt ruimte in hetzelfde contextvenster.</div>
<div class="explainer-note"><strong>Tokens zijn stukjes tekst</strong><br>Een woord kan uit meerdere tokens bestaan. Code en leestekens tellen ook mee.</div>
<p class="context-caption">Het modelmaximum en het ingestelde venster van je runtime kunnen verschillen.</p>
</div>

<div class="explainer-card pipeline-panel pipeline-network">
<h5>2. Eén gedeeld tokenbudget</h5>
<p>Voorbeeld: 8.192 tokens. Meer geschiedenis laat minder antwoordruimte over.</p>
<svg class="context-chart" viewBox="0 0 740 420" role="img" aria-labelledby="context-title context-desc">
<title id="context-title">Invoer en antwoord delen een contextvenster van 8192 tokens</title>
<desc id="context-desc">Eerste voorbeeld: 1024 instructietokens plus 4096 tokens geschiedenis en documenten plus 1024 tokens voor de vraag is 6144 invoertokens. Er blijft 2048 tokens ruimte voor het antwoord. Tweede voorbeeld: de geschiedenis groeit naar 5120 tokens, waardoor de invoer 7168 tokens omvat en nog 1024 tokens voor het antwoord passen. Beide balken beslaan precies 8192 tokens.</desc>
<text x="370" y="25" text-anchor="middle" fill="#fff" font-size="23" font-weight="bold">Eén contextvenster: 8.192 tokens</text>
<text x="18" y="72" fill="#ddd" font-size="21">1. 6.144 invoer + 2.048 antwoordruimte</text>
<rect x="18.0" y="90" width="88.0" height="62" fill="#2dcd4d" stroke="#111" stroke-width="2"/><text x="62.0" y="127" text-anchor="middle" fill="#111" font-size="19" font-weight="bold">1.024</text>
<rect x="106.0" y="90" width="352.0" height="62" fill="#4c8dff" stroke="#111" stroke-width="2"/><text x="282.0" y="127" text-anchor="middle" fill="#111" font-size="19" font-weight="bold">4.096</text>
<rect x="458.0" y="90" width="88.0" height="62" fill="#ff8a33" stroke="#111" stroke-width="2"/><text x="502.0" y="127" text-anchor="middle" fill="#111" font-size="19" font-weight="bold">1.024</text>
<rect x="546.0" y="90" width="176.0" height="62" fill="#a66cff" stroke="#111" stroke-width="2"/><text x="634.0" y="127" text-anchor="middle" fill="#111" font-size="19" font-weight="bold">2.048</text>
<path d="M18,161 V169 H722 V161" fill="none" stroke="#777" stroke-width="2"/>
<text x="18" y="212" fill="#ddd" font-size="21">2. 7.168 invoer + 1.024 antwoordruimte</text>
<rect x="18.0" y="230" width="88.0" height="62" fill="#2dcd4d" stroke="#111" stroke-width="2"/><text x="62.0" y="267" text-anchor="middle" fill="#111" font-size="19" font-weight="bold">1.024</text>
<rect x="106.0" y="230" width="440.0" height="62" fill="#4c8dff" stroke="#111" stroke-width="2"/><text x="326.0" y="267" text-anchor="middle" fill="#111" font-size="19" font-weight="bold">5.120</text>
<rect x="546.0" y="230" width="88.0" height="62" fill="#ff8a33" stroke="#111" stroke-width="2"/><text x="590.0" y="267" text-anchor="middle" fill="#111" font-size="19" font-weight="bold">1.024</text>
<rect x="634.0" y="230" width="88.0" height="62" fill="#a66cff" stroke="#111" stroke-width="2"/><text x="678.0" y="267" text-anchor="middle" fill="#111" font-size="19" font-weight="bold">1.024</text>
<path d="M18,301 V309 H722 V301" fill="none" stroke="#777" stroke-width="2"/>
<text x="370" y="330" text-anchor="middle" fill="#fff" font-size="21">Meer invoer laat minder ruimte voor het antwoord.</text>
<rect x="18" y="348" width="16" height="20" rx="3" fill="#2dcd4d"/><text x="45" y="365" fill="#ddd" font-size="19">Instructies / systeemprompt</text>
<rect x="390" y="348" width="16" height="20" rx="3" fill="#4c8dff"/><text x="417" y="365" fill="#ddd" font-size="19">Geschiedenis / documenten</text>
<rect x="18" y="384" width="16" height="20" rx="3" fill="#ff8a33"/><text x="45" y="401" fill="#ddd" font-size="19">Huidige vraag</text>
<rect x="390" y="384" width="16" height="20" rx="3" fill="#a66cff"/><text x="417" y="401" fill="#ddd" font-size="19">Ruimte voor antwoord</text>
</svg>
<div class="context-summary">Invoer + gegenereerde tokens ≤ contextlengte.<span>Illustratief budget, inclusief chatopmaak. Eventuele redeneertokens tellen ook mee.</span></div>
</div>

<div class="explainer-card pipeline-panel pipeline-output">
<h5>3. Gevolgen in de praktijk</h5>
<p>Kies een venster dat bij je taak, het model en het beschikbare geheugen past.</p>
<div class="explainer-note"><strong>Langere context kost middelen</strong><br>Meer tokens verwerken kan langer duren en meer geheugen vragen, onder andere voor de KV-cache.</div>
<div class="explainer-note"><strong>Als het venster vol raakt</strong><br>De applicatie kan tekst inkorten of samenvatten. De runtime kan een te lang request weigeren of het antwoord begrenzen.</div>
<p class="context-caption">Dit gedrag verschilt per toepassing. Een groter venster garandeert niet dat het model alle informatie goed gebruikt.</p>
</div>
</div>
