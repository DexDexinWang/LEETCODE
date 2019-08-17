title: Hexo Guide
author: Dexin Wang
tags: []
categories:
  - Kits
date: 2019-05-01 22:30:00
---
# [Hexo Guide][1]

> Hexo is a fast, simple and powerful blog framework. You write posts in Markdown (or other languages) and Hexo generates static files with a beautiful theme in seconds.

### Installation

** Pre Requirements: **

* Node.js (at least 6.9)
* Git

** WIndows Installation: **


``` 
$ npm install -g hexo-cli
```

** Linxu Installation: **

```
$ sudo apt-get install git-core / sudo yum install git-core
$ curl -o- https://raw.githubusercontent.com/creationix/nvm/v0.34.0/install.sh | bash
$ nvm install stable
$ install -g hexo-cli
```

** Initlization: **

```
$ cd <git folder>   (optional)
$ hexo init <folder>
$ cd <folder>
$ npm install
```

### Configration

config file: _config.yml


### Commands

** Init **
```
$ hexo init [folder]
```
** New **
```
$ hexo new [layout] <title>
```
** Generate ** 
```
$ hexo new "post title with whitespace"

```
** PUblish **
```
$ hexo generate  
OR
$ hexo g  
```
** Start Server **
```
$ hexo server  
OR
$ hexo s  
```

** Deploy **
```
$ hexo deploy  
OR
$ hexo d
```

** Clean **
```
$ hexo clean  
```

** List **
```
$ hexo list <type>
```

### [Hexo Admin][2]

```
$ npm install --save hexo-admin
$ hexo server -d
$ open http://localhost:4000/admin/
```




[1]:https://hexo.io/
[2]:https://github.com/jaredly/hexo-admin