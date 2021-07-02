# Sitemap Plugin for Crafter CMS

This is a plugin to generate a sitemap for your site.

# Installation

The plugin can be installed to your site from the Crafter CMS Marketplace

# Setup

After the plugin has been installed you can test the result by opening the URL
http://localhost:8080/plugins/org/craftercms/plugin/sitemap/sitemap

The plugin will generate an XML sitemap for the top level pages that are configured with `Place in Nav`, for more
information check the [documentation](https://docs.craftercms.org/en/4.0/developers/form-controls/form-page-order.html).

It is also possible to customize every page with sitemap specific fields:

|Field Type|Field Name|Description|
|:-:|:-:|-|
|`input`|`changeFrequency_s`|Indicates how frequently the page is likely to change. Possible values: always, hourly, daily, weekly, monthly, yearly, never|
|`input`|`priority_f`|Indicates the priority of the page. Possible values: from 0.0 to 1.0|

When the sitemap looks correct a URL rewrite rule can be used to make it available under the main URL of your site:

```xml
<urlrewrite>

    <rule>
        <from>^/sitemap.xml$</from>
        <to>/plugins/org/craftercms/plugin/sitemap/sitemap</to>
    </rule>

</urlrewrite>
```

For more information about the rewrite rules check the [documentation](https://docs.craftercms.org/en/4.0/site-administrators/engine/configure-url-rewrite.html).

Now the sitemap will be available at http://localhost:8080/sitemap.xml and ready to be submitted to a search engine.
