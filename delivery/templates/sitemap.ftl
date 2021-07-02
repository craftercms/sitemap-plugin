<!--
  ~ MIT License
  ~
  ~ Copyright (c) 2018-2021 Crafter Software Corporation. All Rights Reserved.
  ~
  ~ Permission is hereby granted, free of charge, to any person obtaining a copy
  ~ of this software and associated documentation files (the "Software"), to deal
  ~ in the Software without restriction, including without limitation the rights
  ~ to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  ~ copies of the Software, and to permit persons to whom the Software is
  ~ furnished to do so, subject to the following conditions:
  ~
  ~ The above copyright notice and this permission notice shall be included in all
  ~ copies or substantial portions of the Software.
  ~
  ~ THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  ~ IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  ~ FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  ~ AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  ~ LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  ~ OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
  ~ SOFTWARE.
-->
<?xml version="1.0" encoding="utf-8" standalone="yes"?>
<urlset xmlns="http://www.sitemaps.org/schemas/sitemap/0.9">
  <#list pages as page>
  <url>
    <loc>${page.loc}</loc>
    <#if page.lastmod?has_content>
    <lastmod>${page.lastmod}</lastmod>
    </#if>
    <#if page.changefreq?has_content>
    <changefreq>${page.changefreq}</changefreq>
    </#if>
    <#if page.priority?has_content>
    <priority>${page.priority}</priority>
    </#if>
  </url>
  </#list>
</urlset>
