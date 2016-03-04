# `pdfboxing`

Clojure PDF manipulation library & wrapper for [PDFBox](http://pdfbox.apache.org/).

* [![Clojars Project](https://img.shields.io/clojars/v/lupapiste/pdfboxing.svg)](https://clojars.org/lupapiste/pdfboxing)
* [![License](http://img.shields.io/badge/license-BSD-brightgreen.svg?style=flat-square)](http://www.opensource.org/licenses/bsd-license)

## Usage

### Extract text

```clojure
(require '[pdfboxing.text :as text])
(text/extract "test/pdfs/hello.pdf")
```

### Merge multiple PDFs

```clojure
(require '[pdfboxing.merge :as pdf])
(pdf/merge-pdfs :input ["test/pdfs/clojure-1.pdf" "test/pdfs/clojure-2.pdf"] :output "foo.pdf")
```

### Split a PDF into mutliple PDDocuments
```clojure
 (require '[pdfboxing.split :as pdf])
```
List of PDDocument pages 1 through 8
```clojure
 (pdf/split-pdf :input "test/pdfs/multi-page.pdf" :start 1 :end 8)
```
Splits the PDF into single pages as a list of PDDocument
```clojure
 (pdf/split-pdf :input "test/pdfs/multi-page.pdf")
```
Splits the PDF in half and writes them to disk as clojure-1.pdf and clojure-2.pdf
```clojure
 (pdf/split-pdf-at :input "test/pdfs/multi-page.pdf")
```
Splits into two PDFs, the first having 5 pages and second has rest
```clojure
 (pdf/split-pdf-at :input "test/pdfs/multi-page.pdf" :split 5)
```

### List form fields of a PDF

To list fields and values:

```clojure
(require '[pdfboxing.form :as form])
(form/get-fields "test/pdfs/interactiveform.pdf"))
{"Emergency_Phone" "", "ZIP" "", "COLLEGE NO DEGREE" "", ...}
```
### Fill in PDF forms

To fill in form's field supply a hash map with field names and desired
values. It will create a copy of **fillable.pdf** as **new.pdf** with
the fields filled in:

```clojure
(require '[pdfboxing.form :as form])
(form/set-fields "test/pdfs/fillable.pdf" "test/pdfs/new.pdf" {"Text10" "My first name"})
```

### Rename form fields of a PDF

To rename PDF form fields, supply a hash map where the keys are the
current names and the values new names:

```clojure
(require '[pdfboxing.form :as form])
(form/rename-fields "test/pdfs/interactiveform.pdf" "test/pdfs/addr1.pdf" {"Address_1" "NewAddr"})
```
### Get page count of a PDF document

```clojure
(require '[pdfboxing.info :as info])
(info/page-number "test/pdfs/interactiveform.pdf")
```
### Get info about a PDF document

Such as title, author, subject, keywords, creator & producer

```clojure
(require '[pdfboxing.info :as info])
(info/about-doc "test/pdfs/interactiveform.pdf")
```

### Draw lines on a PDF document

Supply a PDF document, a name for the output PDF document, the
coordinates where the line should be drawn along with the page number
on which the line should be drawn

```clojure
(require '[pdfboxing.draw :as draw])
(draw/draw-line :input-pdf "test/pdfs/clojure-1.pdf"
                :output-pdf "ninja.pdf"
                :coordinates {:page-number 0
                              :x 0
                              :y 160
                              :x1 650
                              :y1 160})
```
