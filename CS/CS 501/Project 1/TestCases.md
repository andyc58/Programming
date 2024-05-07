<style>
  .test-annotation-block, .actual-annotation-block {
    outline: 0.05px solid white;
    font-size: 30px;
    }
</style>


## Test Cases

### Case 1: No Kanji
### こんにちは! アンデイです。

Output
<div class="test-annotation-block">


</div>

Actual
<div class="actual-annotation-block">

こんにちは! アンデイです。

</div>

For these cases, my program should output the same thing. No annotations needed because there are no Kanji.

---

### Case 2: Kanji character (No sequence)

### 向こうには何があるの？
Kana annotation for 向: む  
Kana annotation for 何: なに

<br>

Output

<div class="test-annotation-block">
    
</div>

Actual

<div class="actual-annotation-block">
<ruby>向<rt>む</rt></ruby>こうには<ruby>何<rt>なに</rt></ruby>があるの？
</div>

---
### Case 3: Kanji sequences

### 田中さんは学生です。
Kana annotation for 田中: たなか  
Kana annotation for 学生: がくせい  

Output
<div class="test-annotation-block">


</div>


Actual
<div class="actual-annotation-block">
<ruby>田中<rt>たなか</rt></ruby>さんは<ruby>学生<rt>がくせい</rt></ruby>です。
</div>
 
---
### Case 4: Combination of Kanji sequences, 1 Kanji, with numbers
### 山本さんは23才です。
Kana annotation for 山本: やまもと  
Kana annotation for 才: さい  

Output
<div class="test-annotation-block">



</div>


Actual
<div class="actual-annotation-block">
<ruby>山本<rt>やまもと</rt></ruby>さんは23<ruby>才<rt>さい</rt></ruby>です。
</div>
 
---
### Case 5: Complex Noun (has trailing Kanji)
### 経路の日

Kana annotation for 経路: けいろう   
Kana annotation for 日: ひ

Output
<div class="test-annotation-block">


</div>


Actual
<div class="actual-annotation-block">
<ruby>経路<rt>けいろう</rt></ruby>の<ruby>日<rt>ひ</rt></ruby>
</div>

---

### Case 6: Adjective + Noun (has trailing Kanji sequence)
### 高い学生

Kana annotation for 高: たか  
Kana annotation for 学生: がくせい

Output
<div class="test-annotation-block">



</div>


Actual
<div class="actual-annotation-block">
<ruby>高<rt>たか</rt></ruby>い<ruby>学生<rt>がくせい</rt></ruby>
</div>

---
### Case 7: Noun phrase using all 3 scripts (with trailing Kanji characters)

### トムが生まれた月
Kana annotation for 生: う  
Kana annotation for 月: つき  

Output
<div class="test-annotation-block">



</div>


Actual
<div class="actual-annotation-block">

トムが<ruby>生<rt>う</rt></ruby>まれた<ruby>月<rt>つき</rt></ruby>

</div>

---
### Case 8: Romanized chars with the 3 scripts (for technical names)
### Javaプログラミングを勉強してる。

Kana annotation for 勉強: べんきょう 

Output
<div class="test-annotation-block">


</div>

Actual
<div class="actual-annotation-block">

Javaプログラミングを<ruby>勉<rt>べん</rt></ruby><ruby>強<rt>きょう</rt></ruby>してる。

</div>

---
### Case 9: Long sentence with Kanji at the start
### 日本庭園の美が、他の文化には見出されない事を知るのは興味深いことだ。
Kana annotation for 日本庭園: にほんていえん  
Kana annotation for 美: ひ  
Kana annotation for 他: ほか  
Kana annotation for 文化: ぶんか  
Kana annotation for 見出: みいだ  
Kana annotation for 事: こと  
Kana annotation for 知: し  
Kana annotation for 興味深: きょうみぶか  

Output
<div class="test-annotation-block">



</div>

Actual
<div class="actual-annotation-block">

<ruby>日本庭園<rt>にほんていえん</rt></ruby>の<ruby>美<rt>ひ</rt></ruby>が、<ruby>他<rt>ほか</rt></ruby>の<ruby>文化<rt>ぶんか</rt></ruby>には<ruby>見出<rt>みいだ</rt></ruby>されない<ruby>事<rt>こと</rt></ruby>を<ruby>知<rt>し</rt></ruby>るのは<ruby>興味深<rt>きょうみぶか</rt></ruby>いことだ。

</div>

Source: https://jisho.org/sentences/51866a6fd5dda7e98100b9ab

---

### Case 10: Phrase with half-width Katakana

### ｼﾞｮﾝは何歳ですか？　彼は１８歳です。
Kana annotation for 何歳: なんさい  
Kana annotation for 彼: かれ  
Kana annotation for 歳: さい

Output
<div class="test-annotation-block">



</div>

Actual
<div class="actual-annotation-block">

ｼﾞｮﾝは<ruby>何歳<rt>なんさい</rt></ruby>ですか？　<ruby>彼<rt>かれ</rt></ruby>は１８<ruby>歳<rt>さい</rt></ruby>です。

</div>

Nobody really uses half-width Japanese characters, but still good to test out.

---