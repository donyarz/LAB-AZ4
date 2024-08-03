# LAB-AZ4

## تبدیل نیازمندی ها به موارد آزمون با استفاده از روش ایجاد مبتنی بر رفتار(BDD)
<br>

در ادامه مراحل انجام کار در intellig را آورده ام.
<br>

مرحله 1: ایجاد پروژه جدید Maven:

![Screenshot (135)](https://github.com/user-attachments/assets/f90f8901-905a-42d5-b185-73e820c89978)
![Screenshot (136)](https://github.com/user-attachments/assets/24cc7de1-849c-4200-addc-05a25963bc01)
![Screenshot (137)](https://github.com/user-attachments/assets/411e4a2f-7caa-488a-b656-cceb931139ac)
<br>



مرحله دوم: سپس باید depedency های مورد نیاز برای Junit , Cucumber را به pom.xml بیافزاییم:
<br>

<dependencies>
    <dependency>
        <groupId>info.cukes</groupId>
        <artifactId>cucumber-junit</artifactId>
        <version>1.2.5</version>
    </dependency>

    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
    </dependency>

    <dependency>
        <groupId>info.cukes</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>1.2.5</version>
        <scope>test</scope>
    </dependency>
</dependencies>


![Screenshot (138)](https://github.com/user-attachments/assets/e237cb13-5958-445e-aa70-5aa967881463)
<br>


مرحله 3 : Maven > test را اجرا می‌کنیم تا پیغام Build successfull را ببینیم:





![Screenshot (141)](https://github.com/user-attachments/assets/8f781aad-64e5-4335-8bd1-e17c6b0b994d)


<br>


مرحله 4 : ایجاد یک پکیج resousre در پکیج test و انتخاب Mark Directory as Test Resourse Root


![Screenshot (142)](https://github.com/user-attachments/assets/d37713c6-a739-45c6-a294-c7477ee6be75)


![Screenshot (143)](https://github.com/user-attachments/assets/8d2740f1-6029-4686-a8cc-14c81d2908e9)

![Screenshot (144)](https://github.com/user-attachments/assets/5dfdc18e-e0a1-406c-a8b6-e3f97a91fd02)

<br>

مرحله 5:ایجاد پکیج جدید به نام Calculator در مسیر src > main > java و ایجاد دایرکتوری جدید به نام features در مسیر test > resourses


![Screenshot (145)](https://github.com/user-attachments/assets/f85318dd-0d55-4f57-8881-76b450283847)


![Screenshot (146)](https://github.com/user-attachments/assets/9b495923-2a6e-417c-801e-d1c072c44d0f)


![Screenshot (147)](https://github.com/user-attachments/assets/aa1b1b24-7e10-44a9-ade3-077ba408c9f5)

<br>

مرحله 6: ایجاد فایل جدید با عنوان calculator.feature در زیر دایرکتوری feature و نوشتن سناریو جذر تقسیم در آن:
<br>
خطوط زیر به عنوان سناریو در این فایل نوشته شده است:
<br>



![image](https://github.com/user-attachments/assets/455b21be-7698-4def-b593-83d12fd2cf34)


![Screenshot (149)](https://github.com/user-attachments/assets/5a4726a5-91e4-4ed1-9270-200db9963117)

<br>

مشحص است که خطوط زرد رنگ شده است که یعنی نمیتواند آنها را تفسیر کند. باید به انتهای هر کدام از خطوط رفته و  Alt + Enter تا یک فایل جدید جهت ایجاد step ها و سناریو ایجاد گردد.



![Screenshot (150)](https://github.com/user-attachments/assets/ee777bf0-0e1a-4857-81b3-2dc73f8bdc3a)


![Screenshot (153)](https://github.com/user-attachments/assets/418e4a58-98a7-4890-8e9b-342ea47b0d47)


![Screenshot (154)](https://github.com/user-attachments/assets/562f9510-bfac-40b1-92da-16271e4d70a1)

## پروفایلینگ بر روی کلاس جاواکاپ

در ابتدا همانطور که از ما خواسته شد با استفاده از YourKit عملیات پروفایلینگ را بر روی کلاس JavaCup اجرا کردیم و تابعی که بیشترین مصرف منابع را دارد را شناسایی کردیم که تابع temp بود. <br>
تابع temp در کلاس JavaCup به دلایل متعددی منابع زیادی مصرف می‌کند. این تابع یک ArrayList ایجاد می‌کند و آن را با 200 میلیون عنصر پر می‌کند که این مقدار بسیار زیادی از حافظه را مصرف می‌کند. برای اضافه کردن این تعداد زیاد عناصر، تابع از حلقه‌های تو در تو استفاده می‌کند که تعداد عملیات‌ها را به شدت افزایش می‌دهد و زمان اجرای تابع را به طور قابل توجهی بالا می‌برد. علاوه بر این، اگر ظرفیت اولیه ArrayList به طور صریح مشخص نشود، از مقدار پیش‌فرض استفاده می‌کند که معمولاً کوچک است و نیاز به تغییر اندازه مکرر دارد. هر بار که ظرفیت ArrayList پر می‌شود، یک آرایه جدید با اندازه بزرگ‌تر ایجاد می‌شود و عناصر قدیمی به آن کپی می‌شوند که این فرایند نیز به نوبه خود منابع بیشتری از حافظه و پردازش را مصرف می‌کند. به همین دلیل، تابع temp باعث مصرف زیاد منابع می‌شود. <br>
در عکس‌های زیر منابع مصرفی قبل از تغییر این کلاس را مشاهده می‌کنیم: <br> <br>
![2](https://github.com/user-attachments/assets/0d7555c6-6149-4bfe-b82c-f09e048dc4be)
![3](https://github.com/user-attachments/assets/e16779ab-6582-4bb6-922e-967959d2f57a)
![4](https://github.com/user-attachments/assets/5b80ffa4-4058-4fe7-b961-7e004f12acba)
![5](https://github.com/user-attachments/assets/25c22138-2ac2-41b4-823e-0295bcdb7809)
![6](https://github.com/user-attachments/assets/cfbc5358-8a40-4ac3-a245-3f856ebc3aeb)
![7](https://github.com/user-attachments/assets/8f7d3e7b-d723-4054-8f8e-7b69144df58a)
<br> <br> <br>
حال این تابع را کمی تغییر دادیم که در زیر عکس آن را مشاهده می‌کنید: <br> <Br>
![image](https://github.com/user-attachments/assets/321ad441-44cf-41b5-8a0f-936266a0f04e)
<br> <br> <br>
تغییری که در تابع temp انجام داده‌ایم، تعیین ظرفیت اولیه ArrayList به اندازه 200 میلیون عنصر است. در این کد جدید، ArrayList با ظرفیت اولیه 200 میلیون عنصر ایجاد می‌شود. <br>
این تغییر به دلایل متعددی تاثیرگذار است. ابتدا، با تعیین ظرفیت اولیه ArrayList به اندازه 200 میلیون عنصر، نیاز به تغییر اندازه مکرر آرایه درونی ArrayList از بین می‌رود. در پیاده‌سازی اولیه، هر بار که ظرفیت ArrayList پر می‌شد، یک آرایه جدید با اندازه بزرگ‌تر ایجاد و عناصر قدیمی به آن کپی می‌شدند. این عملیات‌های زمان‌بر و منابع‌بر با این تغییر کاهش می‌یابند. <br>
دوم، کاهش عملیات تغییر اندازه موجب کاهش مصرف دسترسی به حافظه می‌شود. عملیات تغییر اندازه مکرر نیاز به تخصیص و آزادسازی پی‌در‌پی حافظه دارد که می‌تواند منجر به مصرف بالای دسترسی به حافظه شود. با مشخص کردن ظرفیت اولیه، نیاز به این عملیات‌ها کاهش می‌یابد و دسترسی به حافظه بهینه‌تر می‌شود. <br>
سوم، این تغییر باعث بهبود کارایی تابع می‌شود. با کاهش عملیات تغییر اندازه و کپی عناصر، زمان اجرای تابع نیز بهبود می‌یابد. این بهبود کارایی به خصوص در برنامه‌هایی با حجم بزرگ داده‌ها محسوس است. <br>
حال در زیر تصاویر مربوط به انجام عملیات پروفایلینگ را بر روی کلاس جاواکاپ با متد تغییر یافته می‌بینیم: <br> <br>
![8](https://github.com/user-attachments/assets/f03808c6-20aa-4f4e-b11e-298cede6adde)
![9](https://github.com/user-attachments/assets/bea97d64-49b8-402f-984a-2be0134c89fc)
![10](https://github.com/user-attachments/assets/9d18764d-64f0-44ae-b865-7f134cad4a6c)
![11](https://github.com/user-attachments/assets/76cba41a-d0f9-4510-8497-e4e4156248e5)
![12](https://github.com/user-attachments/assets/4de6cd59-4f54-48da-a19b-7fa21b6579bd)
![13](https://github.com/user-attachments/assets/de82c5fb-f4e2-4de9-85f6-900df116f63c)
<br> <br> <br>
همانطور که مشاهده میکنید استفاده از منابع و زمان اجرا کاهش یافته است. <br>

## پروفایلینگ بر روی الگوریتم جدید:

کلاس Main از یک لیست مجاورت برای ذخیره‌ی گراف و یک نقشه برای پیگیری رئوس بازدید شده و یک مجموعه برای لبه‌ها استفاده می‌کند. الگوریتم اصلی این کلاس، DFS است که برای پیدا کردن مسیر بین دو رأس به کار می‌رود. ابتدا گراف را از فایل می‌خواند و سپس بررسی می‌کند که آیا مسیری از رأس مبدأ به رأس مقصد وجود دارد یا خیر. در این الگوریتم، از یک پشته برای نگهداری رؤس استفاده می‌شود و به صورت بازگشتی یا با استفاده از یک حلقه، رؤس را پیمایش می‌کند تا زمانی که مسیر مورد نظر پیدا شود یا همه‌ی مسیرها بررسی شوند. در زیر عکس‌های منابع مصرف شده بعد از عملیات پروفایلینگ را مشاهده می‌کنید: <br> <br>
![1](https://github.com/user-attachments/assets/19cc7d4f-851f-4581-85d7-341c4d1a82b2)
![2](https://github.com/user-attachments/assets/a48242dc-db5c-4209-a35d-9f1bc51d5bcb)
![3](https://github.com/user-attachments/assets/2427aa6c-86c3-4c5f-aac2-be7f630ef6fe)
![4](https://github.com/user-attachments/assets/9e2bc298-9ef9-400b-9117-262f0ea493bb)
![5](https://github.com/user-attachments/assets/cc87c809-f8d7-4824-9fbf-82b4702c182f)
<br> <br> <br>
همانطور که مشاهده کردید مشکل در تابع اضافه کردن یال و داده ساختارهای استفاده شده در داخل آن هست که منابع فوق‌العاده زیادی را مصرف می‌کند و باید آن را اصلاح کنیم. <br>
کلاس OptimizedMain نیز هدف مشابهی دارد و از یک لیست مجاورت برای ذخیره‌ی گراف و یک مجموعه برای پیگیری رئوس بازدید شده استفاده می‌کند. الگوریتم اصلی در این کلاس نیز DFS است که بهینه‌سازی‌هایی در آن انجام شده است. این کلاس ابتدا گراف را از فایل می‌خواند و سپس بررسی می‌کند که آیا مسیری از رأس مبدأ به رأس مقصد وجود دارد یا خیر. در این الگوریتم نیز از یک پشته برای نگهداری رؤس استفاده می‌شود و به صورت بازگشتی یا با استفاده از یک حلقه، رؤس را پیمایش می‌کند تا زمانی که مسیر مورد نظر پیدا شود یا همه‌ی مسیرها بررسی شوند. <br>
یکی از این تغییرات عمده، استفاده از HashSet برای ذخیره‌سازی گره‌های بازدید شده به جای HashMap است. این تغییر موجب می‌شود که فقط گره‌های بازدید شده ذخیره شوند، در نتیجه، عملیات بررسی حضور یک گره در مجموعه بازدید شده‌ها سریع‌تر و کم هزینه‌تر خواهد بود. همچنین، این روش حافظه کمتری اشغال می‌کند زیرا نیازی به ذخیره‌سازی مقدار بولین برای هر گره نیست. <br>
علاوه بر این، ساختار edgeMap که در نسخه اولیه وجود داشت و در کد فعلی استفاده نمی‌شد، حذف گردیده است. این حذف باعث ساده‌سازی کد و کاهش مصرف حافظه می‌شود، چرا که دیگر نیازی به نگهداری یک ساختار داده اضافی برای هر گره و مجموعه‌ای از گره‌های متصل به آن نیست. <br>
همچنین، بهبودهایی در نحوه بازدید از همسایه‌های گره‌ها ایجاد شده است. به جای استفاده از حلقه‌های با شاخص، که نیاز به دسترسی مکرر به فهرست همسایه‌ها دارند، از حلقه‌های for-each استفاده می‌شود که به طور مستقیم و بدون نیاز به شمارش، به عناصر دسترسی پیدا می‌کنند. این رویکرد نه تنها خوانایی کد را بهبود می‌بخشد، بلکه سرعت برنامه را نیز در زمان اجرا افزایش می‌دهد. <br>
حال عملیات پروفایلینگ را بر روی این کلاس بهینه شده انجام می‌دهیم که نتایج آن به شکل زیر است: <br> <br>
![6](https://github.com/user-attachments/assets/7b584aff-8e0f-4ef0-9d98-dfc6faf9208f)
![7](https://github.com/user-attachments/assets/ed6ea418-a02f-442c-ba15-6007d830222f)
![8](https://github.com/user-attachments/assets/f16b04a8-5120-4338-972e-3cc35f18147d)
![9](https://github.com/user-attachments/assets/0fcce121-189d-45d8-8ea8-648f4a036141)
![10](https://github.com/user-attachments/assets/29c58d50-e0a6-4d3a-a531-f33be4e2d9ac)
<br> <br> <br>

همانطور که مشاهده می‌کنید در مصرف منابع تغییر زیادی به وجود آمده است و کد بهینه شده است و همچنین مشاهده می‌کنید که تابع اضافه کردن یال و داده ساختارهای موجود در کد دیگر به اندازه قبل منابع را مصرف نمی‌کنند.













