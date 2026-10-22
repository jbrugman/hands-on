<!-- .slide: class="network-slide overflow-slide" -->
#### Context Overflow: wat als het venster vol is?

<div class="explainer-grid pipeline-explainer">
<div class="explainer-card pipeline-panel pipeline-input">
<h5>1. Geen ruimte meer</h5>
<p>Invoer en gegenereerde tokens vullen samen het contextvenster. Hoe ga je verder als er niets meer bij past?</p>
<div class="explainer-note"><strong>Stop</strong><br>Stop generatie bij de grens. De bestaande context blijft intact, het antwoord kan onvolledig zijn.</div>
<div class="explainer-note"><strong>Rolling window</strong><br>Verwijder de oudste context en ga verder met de meest recente delen.</div>
<div class="explainer-note"><strong>Truncate middle</strong><br>Verwijder context uit het midden. Bewaar het begin en recente delen.</div>
<p class="overflow-caption">Dit zijn strategieën voor een vol venster tijdens generatie. Een te grote invoer kan al eerder worden geweigerd.</p>
</div>

<div class="explainer-card pipeline-panel pipeline-network">
<h5>2. Wat blijft in de context?</h5>
<p>Een vol venster met zes schematische delen. Er moet één nieuw deel bij. Doorgestreept = verwijderd.</p>
<svg class="overflow-chart" viewBox="0 0 740 420" role="img" aria-labelledby="overflow-title overflow-desc">
<title id="overflow-title">Stop, rolling window en truncate middle bij een vol contextvenster</title>
<desc id="overflow-desc">Een schematisch venster bevat zes even grote contextdelen: systeemprompt, startvraag, oud A, oud B, recente context en antwoord. Er komt een nieuw deel bij. Stop behoudt de bestaande delen en stopt generatie. Rolling zonder bescherming van het begin verwijdert de systeemprompt en houdt de zes nieuwste delen. Truncate middle verwijdert oud A, zodat systeemprompt, startvraag en recente delen behouden blijven.</desc>
<text x="20" y="24" fill="#4c8dff" font-size="22" font-weight="bold">1. Stop</text>
<rect x="20" y="46" width="92" height="49" rx="7" fill="#152a18" stroke="#2dcd4d" stroke-width="2"/><text x="66" y="77" text-anchor="middle" fill="#2dcd4d" font-size="19" font-weight="bold">SYS</text>
<rect x="120" y="46" width="92" height="49" rx="7" fill="#151c27" stroke="#4c8dff" stroke-width="2"/><text x="166" y="77" text-anchor="middle" fill="#4c8dff" font-size="19" font-weight="bold">Start</text>
<rect x="220" y="46" width="92" height="49" rx="7" fill="#151c27" stroke="#4c8dff" stroke-width="2"/><text x="266" y="77" text-anchor="middle" fill="#4c8dff" font-size="19" font-weight="bold">Oud A</text>
<rect x="320" y="46" width="92" height="49" rx="7" fill="#151c27" stroke="#4c8dff" stroke-width="2"/><text x="366" y="77" text-anchor="middle" fill="#4c8dff" font-size="19" font-weight="bold">Oud B</text>
<rect x="420" y="46" width="92" height="49" rx="7" fill="#151c27" stroke="#4c8dff" stroke-width="2"/><text x="466" y="77" text-anchor="middle" fill="#4c8dff" font-size="19" font-weight="bold">Recent</text>
<rect x="520" y="46" width="92" height="49" rx="7" fill="#151c27" stroke="#a66cff" stroke-width="2"/><text x="566" y="77" text-anchor="middle" fill="#a66cff" font-size="19" font-weight="bold">Antw.</text>
<rect x="620" y="46" width="92" height="49" rx="7" fill="#301818" stroke="#ff6666" stroke-width="2"/><text x="666" y="77" text-anchor="middle" fill="#ff6666" font-size="19" font-weight="bold">Nieuw</text>
<path d="M624,101 H708" stroke="#ff6666" stroke-width="3"/>
<text x="20" y="124" fill="#ddd" font-size="20">Vol = stoppen. Het antwoord kan onaf zijn.</text>
<text x="20" y="164" fill="#4c8dff" font-size="22" font-weight="bold">2. Rolling window</text>
<rect x="20" y="186" width="92" height="49" rx="7" fill="#282828" stroke="#666" stroke-width="2"/><text x="66" y="217" text-anchor="middle" fill="#666" font-size="19" font-weight="bold">SYS</text>
<path d="M26,190 L106,231" stroke="#ff6666" stroke-width="2"/>
<rect x="120" y="186" width="92" height="49" rx="7" fill="#151c27" stroke="#4c8dff" stroke-width="2"/><text x="166" y="217" text-anchor="middle" fill="#4c8dff" font-size="19" font-weight="bold">Start</text>
<rect x="220" y="186" width="92" height="49" rx="7" fill="#151c27" stroke="#4c8dff" stroke-width="2"/><text x="266" y="217" text-anchor="middle" fill="#4c8dff" font-size="19" font-weight="bold">Oud A</text>
<rect x="320" y="186" width="92" height="49" rx="7" fill="#151c27" stroke="#4c8dff" stroke-width="2"/><text x="366" y="217" text-anchor="middle" fill="#4c8dff" font-size="19" font-weight="bold">Oud B</text>
<rect x="420" y="186" width="92" height="49" rx="7" fill="#151c27" stroke="#4c8dff" stroke-width="2"/><text x="466" y="217" text-anchor="middle" fill="#4c8dff" font-size="19" font-weight="bold">Recent</text>
<rect x="520" y="186" width="92" height="49" rx="7" fill="#151c27" stroke="#a66cff" stroke-width="2"/><text x="566" y="217" text-anchor="middle" fill="#a66cff" font-size="19" font-weight="bold">Antw.</text>
<rect x="620" y="186" width="92" height="49" rx="7" fill="#151c27" stroke="#ff8a33" stroke-width="2"/><text x="666" y="217" text-anchor="middle" fill="#ff8a33" font-size="19" font-weight="bold">Nieuw</text>
<text x="20" y="264" fill="#ff8a33" font-size="20">Oudste deel weg: hier verdwijnt de systeemprompt.</text>
<text x="20" y="304" fill="#4c8dff" font-size="22" font-weight="bold">3. Truncate middle</text>
<rect x="20" y="326" width="92" height="49" rx="7" fill="#152a18" stroke="#2dcd4d" stroke-width="2"/><text x="66" y="357" text-anchor="middle" fill="#2dcd4d" font-size="19" font-weight="bold">SYS</text>
<rect x="120" y="326" width="92" height="49" rx="7" fill="#151c27" stroke="#4c8dff" stroke-width="2"/><text x="166" y="357" text-anchor="middle" fill="#4c8dff" font-size="19" font-weight="bold">Start</text>
<rect x="220" y="326" width="92" height="49" rx="7" fill="#282828" stroke="#666" stroke-width="2"/><text x="266" y="357" text-anchor="middle" fill="#666" font-size="19" font-weight="bold">Oud A</text>
<path d="M226,330 L306,371" stroke="#ff6666" stroke-width="2"/>
<rect x="320" y="326" width="92" height="49" rx="7" fill="#151c27" stroke="#4c8dff" stroke-width="2"/><text x="366" y="357" text-anchor="middle" fill="#4c8dff" font-size="19" font-weight="bold">Oud B</text>
<rect x="420" y="326" width="92" height="49" rx="7" fill="#151c27" stroke="#4c8dff" stroke-width="2"/><text x="466" y="357" text-anchor="middle" fill="#4c8dff" font-size="19" font-weight="bold">Recent</text>
<rect x="520" y="326" width="92" height="49" rx="7" fill="#151c27" stroke="#a66cff" stroke-width="2"/><text x="566" y="357" text-anchor="middle" fill="#a66cff" font-size="19" font-weight="bold">Antw.</text>
<rect x="620" y="326" width="92" height="49" rx="7" fill="#151c27" stroke="#ff8a33" stroke-width="2"/><text x="666" y="357" text-anchor="middle" fill="#ff8a33" font-size="19" font-weight="bold">Nieuw</text>
<text x="20" y="404" fill="#ddd" font-size="20">Midden weg: begin en recente context blijven.</text>
</svg>
<div class="overflow-summary">Rolling toont hier de variant zonder bescherming van de systeemprompt.<span>Gelijke blokken illustreren contextdelen, geen echte berichtlengtes of tokenaantallen.</span></div>
</div>

<div class="explainer-card pipeline-panel pipeline-output">
<h5>3. Rolling kan tegenwerken</h5>
<p>De systeemprompt staat vaak vooraan. Als die uit het venster schuift, ontbreken de instructies bij verdere generatie.</p>
<div class="explainer-note"><strong>Afspraken kunnen verdwijnen</strong><br>Denk aan rol, antwoordformaat en taakregels. Het model kan daardoor anders gaan reageren.</div>
<div class="explainer-note"><strong>Controleer wat behouden blijft</strong><br>Sommige runtimes bewaren de systeemprompt apart. Truncate middle bewaart in LM Studio ook de eerste gebruikersboodschap.</div>
<p class="overflow-caption">Ook truncate middle verliest informatie: belangrijke details of afspraken uit het midden kunnen verdwijnen.</p>
</div>
</div>
