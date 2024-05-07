
Japanese Annotations

## Project Background / Description

In Japanese, there are 3 standard writing styles: Hiragana, Katakana, and Kanji. The first 2 represent the sounds of the language, which I have learned to read quite effectively. Kanji are borrowed Chinese characters that represent ideas and distinguish words. They can have multiple readings depending on the word and context, which is why the only way to truly learn them is through vocabulary. As a learner, I love placing annotations (also known as Furigana) on top of the Kanji in sentences, so that I know how they are read. Not many note taking apps support these kinds of annotations though. The editor that I use for my notes is Obsidian, which does support it using HTML syntax in combination with Markdown. To achieve this, HTML uses the `<ruby>` and `<rt>` tags. 

An annotation follows this syntax in HTML

```html
<ruby>[Kanji sequence]<rt>[Kana reading]</rt></ruby>
```

All sentences do is chain these with non-Kanji characters. This program will take in a Japanese sentence and build the HTML annotated string given readings for the Kanji sequences in that sentence.

## Instructions on how to test

It is a bit complicated to test this kind of program out because firstly, the inputs are in a different language and secondly, the result is an HTML string, which would require an HTML/Markdown editor or a web browser to render. You will first need to download a markdown preview extension in VSCode. I would go with **Markdown All in One**. When downloaded click on the icon in the top right corner next to the split editor button while in the **`TestCases.md`**  file. It looks just like it but with a magnifying glass. This will open a preview panel for the **`TestCases.md`** file with the markdown rendered.


To test,

1. Run the program and copy-paste a Japanese sentence (excluding the heading marks) in the test cases section
2. Copy-paste each annotation one-by-one. The program will ask you one for each Kanji sequence
3. When the final HTML string is printed, copy-paste the string into the empty `div` test annotation block located for each test case and compare how it renders to the sentence below it in the actual annotation block
4. Type "y" or "yes" when prompted and the program will loop back to prompt for the next sentence.
5. Repeat for each test case!
6. When done with everything enter "n" or "no" and the program will stop! 

