<!-- .slide: class="network-slide repeat-slide" -->
#### Repeat Penalty: herhaling afremmen

<div class="explainer-grid pipeline-explainer">
<div class="explainer-card pipeline-panel pipeline-input">
<h5>1. Welke tokens zijn al gebruikt?</h5>
<p>De tekst is <strong>“de kat”</strong>. Van de volgende kandidaten komt <strong>“kat”</strong> al in deze tekst voor.</p>
<div class="score-caption">Voorbeeldscores uit het model</div>
<table class="score-table"><thead><tr><th>Token</th><th>Score</th><th>Al gebruikt?</th></tr></thead><tbody><tr><td>kat</td><td>3,0</td><td>ja</td></tr><tr><td>ligt</td><td>2,0</td><td>nee</td></tr><tr><td>zit</td><td>1,0</td><td>nee</td></tr><tr><td>slaapt</td><td>0,0</td><td>nee</td></tr></tbody></table>
<div class="explainer-note"><strong>Eerder gebruikte tokens afremmen</strong><br>Een penalty boven 1 verlaagt hun scores. Daarna berekent softmax de kansen opnieuw.</div>
<p class="repeat-caption">Fictief voorbeeld met vier tokens. Alleen “kat” krijgt hier een penalty. Temperature blijft 1, andere filters staan uit.</p>
</div>

<div class="explainer-card pipeline-panel pipeline-network">
<h5>2. Minder kans op hetzelfde token</h5>
<p>Voor de positieve score van “kat” geldt: score delen door de penalty. De andere modelscores blijven gelijk.</p>
<svg class="repeat-chart" viewBox="0 0 740 420" role="img" aria-labelledby="repeat-title repeat-desc">
<title id="repeat-title">Repeat Penalty verlaagt de score van een eerder gebruikt token</title>
<desc id="repeat-desc">In de tekst de kat is kat al gebruikt. De voorbeeldscores van kat, ligt, zit en slaapt zijn 3, 2, 1 en 0. Alleen de score van kat wordt aangepast. Bij penalty 1 blijft die 3, bij 1,2 wordt die 2,5 en bij 1,5 wordt die 2. Softmax berekent daarna de nieuwe kansen. Kat wordt minder waarschijnlijk, maar blijft mogelijk.</desc>
<text x="0" y="22" fill="#4c8dff" font-size="22" font-weight="bold">Penalty = 1,0</text><text x="240" y="22" fill="#ddd" font-size="19">Score “kat”: 3,00 / 1,0 = 3,00</text>
<text x="0" y="54" fill="#ff8a33" font-size="19">kat</text><rect x="90" y="38" width="540" height="18" rx="3" fill="#252525"/><rect x="90" y="38" width="347.714" height="18" rx="3" fill="#ff8a33"/><text x="645" y="54" fill="#fff" font-size="19">64,4%</text>
<text x="0" y="77" fill="#2dcd4d" font-size="19">ligt</text><rect x="90" y="61" width="540" height="18" rx="3" fill="#252525"/><rect x="90" y="61" width="127.917" height="18" rx="3" fill="#2dcd4d"/><text x="645" y="77" fill="#fff" font-size="19">23,7%</text>
<text x="0" y="100" fill="#4c8dff" font-size="19">zit</text><rect x="90" y="84" width="540" height="18" rx="3" fill="#252525"/><rect x="90" y="84" width="47.058" height="18" rx="3" fill="#4c8dff"/><text x="645" y="100" fill="#fff" font-size="19">8,7%</text>
<text x="0" y="123" fill="#a66cff" font-size="19">slaapt</text><rect x="90" y="107" width="540" height="18" rx="3" fill="#252525"/><rect x="90" y="107" width="17.312" height="18" rx="3" fill="#a66cff"/><text x="645" y="123" fill="#fff" font-size="19">3,2%</text>
<text x="0" y="162" fill="#4c8dff" font-size="22" font-weight="bold">Penalty = 1,2</text><text x="240" y="162" fill="#ddd" font-size="19">Score “kat”: 3,00 / 1,2 = 2,50</text>
<text x="0" y="194" fill="#ff8a33" font-size="19">kat</text><rect x="90" y="178" width="540" height="18" rx="3" fill="#252525"/><rect x="90" y="178" width="282.464" height="18" rx="3" fill="#ff8a33"/><text x="645" y="194" fill="#fff" font-size="19">52,3%</text>
<text x="0" y="217" fill="#2dcd4d" font-size="19">ligt</text><rect x="90" y="201" width="540" height="18" rx="3" fill="#252525"/><rect x="90" y="201" width="171.323" height="18" rx="3" fill="#2dcd4d"/><text x="645" y="217" fill="#fff" font-size="19">31,7%</text>
<text x="0" y="240" fill="#4c8dff" font-size="19">zit</text><rect x="90" y="224" width="540" height="18" rx="3" fill="#252525"/><rect x="90" y="224" width="63.026" height="18" rx="3" fill="#4c8dff"/><text x="645" y="240" fill="#fff" font-size="19">11,7%</text>
<text x="0" y="263" fill="#a66cff" font-size="19">slaapt</text><rect x="90" y="247" width="540" height="18" rx="3" fill="#252525"/><rect x="90" y="247" width="23.186" height="18" rx="3" fill="#a66cff"/><text x="645" y="263" fill="#fff" font-size="19">4,3%</text>
<text x="0" y="302" fill="#4c8dff" font-size="22" font-weight="bold">Penalty = 1,5</text><text x="240" y="302" fill="#ddd" font-size="19">Score “kat”: 3,00 / 1,5 = 2,00</text>
<text x="0" y="334" fill="#ff8a33" font-size="19">kat</text><rect x="90" y="318" width="540" height="18" rx="3" fill="#252525"/><rect x="90" y="318" width="215.723" height="18" rx="3" fill="#ff8a33"/><text x="645" y="334" fill="#fff" font-size="19">39,9%</text>
<text x="0" y="357" fill="#2dcd4d" font-size="19">ligt</text><rect x="90" y="341" width="540" height="18" rx="3" fill="#252525"/><rect x="90" y="341" width="215.723" height="18" rx="3" fill="#2dcd4d"/><text x="645" y="357" fill="#fff" font-size="19">39,9%</text>
<text x="0" y="380" fill="#4c8dff" font-size="19">zit</text><rect x="90" y="364" width="540" height="18" rx="3" fill="#252525"/><rect x="90" y="364" width="79.360" height="18" rx="3" fill="#4c8dff"/><text x="645" y="380" fill="#fff" font-size="19">14,7%</text>
<text x="0" y="403" fill="#a66cff" font-size="19">slaapt</text><rect x="90" y="387" width="540" height="18" rx="3" fill="#252525"/><rect x="90" y="387" width="29.195" height="18" rx="3" fill="#a66cff"/><text x="645" y="403" fill="#fff" font-size="19">5,4%</text>
</svg>
<div class="repeat-summary">Oranje: eerder gebruikt token “kat”. Balklengte: kans.<span>Penalty 1,0 heeft geen effect. Een hogere penalty verlaagt hier de kans op “kat”.</span></div>
</div>

<div class="explainer-card pipeline-panel pipeline-output">
<h5>3. Effect en kanttekening</h5>
<p>Repeat Penalty kan ongewenste herhaling afremmen. Het eerder gebruikte token blijft een mogelijke keuze.</p>
<div class="explainer-note"><strong>Geen begrip van herhaling</strong><br>Het filter herkent eerder gebruikte tokens. Het beoordeelt niet of herhaling inhoudelijk nodig is.</div>
<div class="explainer-note"><strong>Kan tegenwerken bij code schrijven</strong><br>Code moet variabelenamen, keywords en symbolen juist herhalen. Een te sterke penalty kan namen inconsistent maken of ongeldige code opleveren.</div>
<p class="repeat-caption">De runtime bepaalt welke eerdere tokens meetellen. Stem de instelling af op het model en je taak.</p>
</div>
</div>
