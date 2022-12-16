package io.intertec.retrofittrainingwithjetpackcompose.data.models

data class Quote(
  val _id: String,
  val author: String,
  val authorSlug: String,
  val content: String,
  val dateAdded: String,
  val dateModified: String,
  val length: Int,
  val tags: List<String>
)
