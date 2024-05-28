import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';

@Component({
  selector: 'app-category-maintainer',
  standalone: true,
  imports: [MatButtonModule, MatTableModule],
  templateUrl: './category-maintainer.component.html',
  styleUrl: './category-maintainer.component.scss',
})
export class CategoryMaintainerComponent {
  dataSource: MatTableDataSource<any> = new MatTableDataSource<any>();
  displayedColumns = [
    { matColumnDef: 'id_category', label: 'ID' },
    { matColumnDef: 'category_name', label: 'Nombre Categoria' },
    { matColumnDef: 'creation_date_category', label: 'Fecha Creación' },
    { matColumnDef: 'id_sub_category', label: 'ID Sub-Categoria' },
    { matColumnDef: 'sub_category_name', label: 'Nombre Sub-Categoria' },
    {
      matColumnDef: 'creation_date_sub_category',
      label: 'Fecha Creación Sub-Categoria',
    },
  ];

  get columnsName(){
    return this.displayedColumns.map( (col: any) => col.matColumnDef);
  }
}
