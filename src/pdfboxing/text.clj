(ns pdfboxing.text
  (:require [pdfboxing.common :as common])
  (:import [org.apache.pdfbox.text PDFTextStripper]))

(defn extract
  "get text from a PDF document"
  [pdfdoc]
  (with-open [doc (common/load-pdf pdfdoc)]
    (let [stripper (new PDFTextStripper)]
      (.getText stripper doc))))
