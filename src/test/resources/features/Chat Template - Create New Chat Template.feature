Feature: Chat Template - Create New Chat Template

  Background:
#    Given User sudah login
    And User berada di halaman Chat Template
    And User belum pernah membuat Chat Template sebelumnya dan terdapat button Create New Template
    When User menekan button Create New Template
    Then Menampilkan pop-up Create New Chat Template

  Scenario: User menekan button Create New Template
    Then terbagi menjadi 2 bagian, yaitu bagian Editorial Template dan bagian Preview Template
    And pada bagian Editorial Template terdapat input form Template Name dan button Load Existing Box bubble chat 1 button Add Bubble Chat dan button Wait For Second Input form Template Hotkey
    And pada bagian Preview Template akan menampilkan contoh pesan seperti pada Bubble chat yang telah ditambahkan
    And pada kanan bawah pop-up terdapat button Create Template

  Scenario: User memberi nama template
    When User klik dan mengetikkan "Promo produk" pada form Template Name
    Then Input form Template Name akan aktif dan terisi "Promo produk"

  Scenario: User membuat pesan pada bubble chat 1
    When User klik dan mengetikkan "Promo produk terbaru tahun ini" pada form box Bubble Chat 1
    Then Box bubble chat 1 akan terisi pesan "Promo produk terbaru tahun ini"
    And pada bagian Preview menampilkan bubble chat 1 dengan pesan "Promo produk terbaru tahun ini"


  Scenario: User menambahkan bubble chat baru
    When User klik button Add Bubble Chat
    Then Akan muncul bubble chat baru pada bagian Editorial Template

  Scenario: User membuat pesan pada bubble chat 2
    When User klik button Add Bubble Chat
    Then Akan muncul bubble chat baru pada bagian Editorial Template
    When User klik button Add File pada bubble chat 2
    And tambah image pada bubble chat 2
    Then Image yang dipilih akan ditambahkan pada box bubble chat 2
    And pada bagian Preview menampilkan bubble chat 2 dengan pesan Image yang ditambahkan


  Scenario: User menambahkan text pada bubble chat 2
    When User klik dan mengetikkan "Promo produk terbaru tahun ini" pada form box Bubble Chat 1
    Then Box bubble chat 1 akan terisi pesan "Promo produk terbaru tahun ini"
    And pada bagian Preview menampilkan bubble chat 1 dengan pesan "Promo produk terbaru tahun ini"
    When User klik button Add Bubble Chat
    Then Akan muncul bubble chat baru pada bagian Editorial Template
    When User klik button Add File pada bubble chat 2
    And tambah image pada bubble chat 2
    Then Image yang dipilih akan ditambahkan pada box bubble chat 2
    And pada bagian Preview menampilkan bubble chat 2 dengan pesan Image yang ditambahkan
    When User klik dan mengetikkan "Produk 1, potongan harga 20ribu" pada form box Bubble Chat 2
    Then Box bubble chat 2 akan terisi pesan "Produk 1, potongan harga 20ribu"
    And pada bagian Preview menampilkan bubble chat 2 dengan pesan "Produk 1, potongan harga 20ribu"

  Scenario: User mengganti Template Hotkey
  When User klik dan mengetikkan "Promo2024" pada form Template Hotkey
  Then Input form Template Hotkey akan aktif dan terisi "Promo2024"


  Scenario Outline: User klik button Create Template
    When User klik dan mengetikkan "Promo produk" pada form Template Name
    Then Input form Template Name akan aktif dan terisi "Promo produk"
    When User klik dan mengetikkan "Promo produk terbaru tahun ini" pada form box Bubble Chat 1
    Then Box bubble chat 1 akan terisi pesan "Promo produk terbaru tahun ini"
    And pada bagian Preview menampilkan bubble chat 1 dengan pesan "Promo produk terbaru tahun ini"
    When User klik button Add Bubble Chat
    Then Akan muncul bubble chat baru pada bagian Editorial Template
    When User klik button Add File pada bubble chat 2
    And tambah image pada bubble chat 2
    Then Image yang dipilih akan ditambahkan pada box bubble chat 2
    And pada bagian Preview menampilkan bubble chat 2 dengan pesan Image yang ditambahkan
    When User klik dan mengetikkan "Produk 1, potongan harga 20ribu" pada form box Bubble Chat 2
    Then Box bubble chat 2 akan terisi pesan "Produk 1, potongan harga 20ribu"
    And pada bagian Preview menampilkan bubble chat 2 dengan pesan "Produk 1, potongan harga 20ribu"
    When User klik dan mengetikkan "Promo2024" pada form Template Hotkey
    Then Input form Template Hotkey akan aktif dan terisi "Promo2024"
    When user click button create template
    Then Pop-up akan tertutup
    And template akan bertambah pada tabel daftar template dengan isi kolom "<Template Name>", "<Hotkey>", "<Created Time>", dan "<Guide Book>"
    And pada bagian kanan tabel akan terdapat kolom button Edit dan Delete
    When User menekan button Create New Template
    Then Menampilkan pop-up Create New Chat Template
    Then terbagi menjadi 2 bagian, yaitu bagian Editorial Template dan bagian Preview Template
    And pada bagian Editorial Template terdapat input form Template Name dan button Load Existing Box bubble chat 1 button Add Bubble Chat dan button Wait For Second Input form Template Hotkey
    And pada bagian Preview Template akan menampilkan contoh pesan seperti pada Bubble chat yang telah ditambahkan
    And pada kanan bawah pop-up terdapat button Create Template
    When User klik button Load Existing
    Then Menampilkan dropdown daftar pilihan Chat Template yang telah dibuat sebelumnya
    Examples:
      | Template Name | Hotkey    | Created Time | Guide Book |
      | Promo produk  | Promo2024 | [Today]      | -          |










