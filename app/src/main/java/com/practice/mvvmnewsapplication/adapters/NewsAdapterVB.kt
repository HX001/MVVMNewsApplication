package com.practice.mvvmnewsapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.practice.mvvmnewsapplication.databinding.ItemArticlePreviewBinding
import com.practice.mvvmnewsapplication.models.Article

class NewsAdapterVB (): RecyclerView.Adapter<NewsAdapterVB.ArticleViewHolder>() {

    inner class ArticleViewHolder(val binding: ItemArticlePreviewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            Glide.with(binding.root)
                .load(article.urlToImage)
                .into(binding.articleImage)

            binding.articleTitle.text = article.title
            binding.articleSource.text = article.source.name
            binding.articleDescription.text = article.description
            binding.articleDateTime.text = article.publishedAt

            binding.root.setOnClickListener {
                onItemClickListener?.let {
                    it(article)
                }
            }
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding =  ItemArticlePreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]
//        holder.bind(article)
        holder.binding.apply {
            articleTitle.text = article.title
            articleSource.text = article.source.name
            articleDescription.text = article.description
            articleDateTime.text = article.publishedAt

            root.setOnClickListener {
                onItemClickListener?.let {
                    it(article)
                }
            }
        }
    }

    private var onItemClickListener: ((Article) -> Unit)? = null
}